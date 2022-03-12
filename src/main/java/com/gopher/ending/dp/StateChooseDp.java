package com.gopher.ending.dp;

import java.util.*;

/**
 * @Title StateChooseDp
 * @Author fyw
 * @Date 2022-03-12 12:14
 * @Description 状态选择DP
 */
public class StateChooseDp {
    static class Code943 {       // 最短超级串
        public int get(String a, String b) {
            for (int i = Math.min(a.length(), b.length()); i >= 0; i--) {
                if (a.substring(a.length() - i).equals(b.substring(0, i))) {
                    return i;
                }
            }
            return 0;
        }

        public String shortestSuperstring(String[] words) {
            int n = words.length;
            int[][] tr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tr[i][j] = get(words[i], words[j]);
                }
            }
            int[][] dp = new int[1 << n][n];
            for (int[] d : dp) {
                Arrays.fill(d, (int) 1e9);
            }
            for (int i = 0; i < n; i++) {
                dp[1 << i][i] = words[i].length();
            }
            for (int i = 1; i < 1 << n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] == (int) 1e9) {
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if (((i >> k) & 1) == 0) {
                            dp[i | 1 << k][k] = Math.min(dp[i | 1 << k][k], dp[i][j] + words[k].length() - tr[j][k]);
                        }
                    }
                }
            }
            int last = 0;
            for (int i = 1; i < n; i++) {
                if (dp[(1 << n) - 1][i] < dp[(1 << n) - 1][last]) {
                    last = i;
                }
            }
            List<Integer> q = new ArrayList<>();
            int cur = (1 << n) - 1;
            q.add(last);
            while (q.size() != n) {
                for (int i = 0; i < n; i++) {
                    if (((cur >> i) & 1) == 1 && dp[cur][last] == dp[cur - (1 << last)][i] + words[last].length() - tr[i][last]) {
                        cur -= 1 << last;
                        last = i;
                        q.add(last);
                        break;
                    }
                }
            }
            String res = words[q.get(n - 1)];
            for (int i = n - 2; i >= 0; i--) {
                res += words[q.get(i)].substring(tr[q.get(i + 1)][q.get(i)]);
            }
            return res;
        }

    }
}
