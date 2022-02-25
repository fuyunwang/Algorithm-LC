package com.gopher.leetcode.order.or500;

/**
 * @Title Code5156
 * @Author fyw
 * @Date 2022/2/9 12:34
 * @Description: 最长回文子序列、最长回文子串
 * dp
 */
public class Code516 {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        s=" "+s;

        // f[i,j] 表示i到j区间中最长回文子序列长度
            // 四种情况, i在j在, i不在j不在，i在j不在和i不在j在采用重复覆盖的方式
        // 区间DP，枚举长度并枚举左端点
        int[][] f=new int[n+1][n+1];
        for(int len = 1;len <= n;len ++) {
            for(int i = 1;i + len - 1 <= n;i ++) {
                int j = i + len - 1;
                if(len == 1) f[i][j] = 1;
                else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                    if(s.charAt(i) == s.charAt(j)) f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        return f[1][n];
    }
}
