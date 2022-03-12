package com.gopher.ending.dp;

/**
 * @Title SequenceDp
 * @Author fyw
 * @Date 2022-03-12 12:42
 * @Description
 */
public class SequenceDp {
    static class Code960{
        // 删列造序
        public int minDeletionSize(String[] strs) {
            int n = strs.length, m = strs[0].length();
            int[] f = new int[m];
            int res = m;

            for (int i = 0; i < m; ++i) {
                f[i] = i;
                for (int j = 0; j < i; ++j) {
                    if (check(strs, j, i)) {
                        f[i] = Math.min(f[i], f[j] + i - j - 1);
                    }
                }
                res = Math.min(res, f[i] + m - 1 - i);
            }
            return res;
        }

        private boolean check(String[] strs, int j, int i) {
            int n = strs.length;
            for (int k = 0; k < n; ++k) {
                if (strs[k].charAt(j) > strs[k].charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
