package com.gopher.leetcode.dp;

/**
 * @Title Code688
 * @Author fyw
 * @Date 2022/2/17 12:32
 * @Description:
 */
public class Code688 {
    public double knightProbability(int n, int k, int r, int c) {
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][k] = 1;
            }
        }
        int[] dx = new int[]{-2, -2, 2, 2, -1, -1, 1, 1};
        int[] dy = new int[]{-1, 1, -1, 1, 2, -2, 2, -2};
        for (int u = k - 1; u >= 0; u--) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            dp[i][j][u] += dp[nx][ny][u + 1] / 8;
                        }
                    }
                }
            }
        }
        return dp[r][c][0];
    }

}
