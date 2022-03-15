package com.gopher.leetcode.order.or1000;

import java.util.Arrays;

/**
 * @Title Code1000
 * @Author fyw
 * @Date 2022/3/15 21:27
 * @Description:
 */
public class Code1000 {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length, INF = 0x3f3f3f3f;
        int[][][] f = new int[n][n][K + 1];
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                Arrays.fill(f[i][j], INF);
        int[] sum = new int[n + 1];
        if ((n - 1) % (K - 1) != 0) return -1;
        for (int i = 0; i < n; i ++){
            f[i][i][1] = 0;
            sum[i + 1] = sum[i] + stones[i];
        }
        // dp
        for (int len = 2; len <= n; len ++){
            for (int i = 0; i + len - 1 < n; i ++){
                int j = len + i - 1;
                // 枚举可合并的堆数
                for (int k = 2; k <= K; k ++){
                    // 枚举分界点
                    for (int u = i; u < j; u ++){
                        // i~j成为k堆有不同分法
                        f[i][j][k] = Math.min(f[i][j][k], f[i][u][k - 1] + f[u + 1][j][1]);
                        // System.out.println(i + " " + j + " " + k + " ->" + f[i][j][k]);
                    }
                }
                // 合并成一堆需要的代价
                f[i][j][1] = Math.min(f[i][j][K] + sum[j + 1] - sum[i], f[i][j][1]);
            }
        }
        return f[0][n - 1][1];
    }
}
