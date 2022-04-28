package com.gopher.leetcode.order.or10;

/**
 * @Title Code10
 * @Author fyw
 * @Date 2022/2/3 19:56
 * @Description: 正则表达式匹配
 * 乘公比错位相减，分类讨论
 */
public class Code10 {
    /**
     * 无匹配符考虑对应字符相等
     * .考虑单个字符匹配
     * *必须与前一个字符共同构成匹配，不能单独出现，所以*的匹配0个字符、一个字符和多个字符的匹配过程
     * f[i][j]=f[i][j-2]
     * f[i][j]=f[i-1][j-1]
     * f[i][j]=f[i-1][j]
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n=s.length();
        int m=p.length();
        s=" "+s;
        p=" "+p;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j)=='*'){
                dp[0][j]=dp[0][j-2];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i][j] = dp[i][j - 2];    // *匹配0个字符
                    } else {
                        dp[i][j] = (dp[i-1][j] || dp[i][j - 2]);  // 匹配多个字符
                            /*
                                dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                                or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                                or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */
                    }
                }
            }
        }
        return dp[n][m];
    }
}
