package com.gopher.leetcode.order.or500;

/**
 * @Title Code583
 * @Author fyw
 * @Date 2022/2/9 12:31
 * @Description: 两个字符串的删除操作
 * 编辑距离、最长公共子序列
 */
public class Code583 {
    public int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
