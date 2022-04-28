package com.gopher.leetcode.order.or50;

/**
 * @Title Code44
 * @Author fyw
 * @Date 2022/2/9 14:13
 * @Description: 通配符匹配
 * 与Code10正则表达式匹配一类题型，DP
 */
public class Code44 {
    // 递推公式的讨论要不重不漏
    /**
     * 1. 如果pi是小写字母，那么si也需要是小写字母即：dp[i][j]=dp[i-1][j-1]&&pi=si
     * 2. 如果pi是?，那么si是什么都可以即：dp[i][j]=dp[i-1][j-1]
     * 3. 如果pi是*，那么pi在匹配时可以采用也可以不采用即：dp[i][j]=dp[i-1][j]||dp[i][j-1] 或前面是使用后面是不使用
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 10][n + 10];
        dp[0][0] = true;
        s=" "+s;
        p=" "+p;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
