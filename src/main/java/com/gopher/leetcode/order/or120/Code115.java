package com.gopher.leetcode.order.or120;

/**
 * @Title Code115
 * @Author fyw
 * @Date 2022/2/9 13:56
 * @Description: 不同的子序列
 * dp，二维考虑f[i][j]
 */
public class Code115 {
    // f[i][j] 表示s[1~i]的所有和t[1~j]相等的子序列
    // 考虑最后一个字符
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        s=" "+s;
        t=" "+t;
        int[][] f=new int[n+1][m+1];
        // 定义初始条件，如果t为0，那么无论s采用多少个字符都可以匹配，因为可以都不选
        for (int i = 0; i <= n; i++) {
            f[i][0]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 不用
                f[i][j]=f[i-1][j];
                // 用，有条件
                if (s.charAt(i)==t.charAt(j)){
                    f[i][j]+=f[i-1][j-1];
                }
            }
        }
        return f[n][m];
    }
}
