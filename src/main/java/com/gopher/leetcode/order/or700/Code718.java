package com.gopher.leetcode.order.or700;

/**
 * @Title Code718
 * @Author fyw
 * @Date 2022/2/8 22:04
 * @Description: 最长重复子数组
 */
public class Code718 {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
