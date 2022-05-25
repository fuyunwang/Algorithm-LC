package com.fuyunwang.bilibili.order.subarr;

/**
 * @Title Code115
 * @Author fyw
 * @Date 2022-05-25 15:41
 * @Description 不同的子序列
 * dp
 */
public class Code115 {
    /**
     * s[1~i]和t[1~j]相等的子序列的数量
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        s="　"+s;
        t="　"+t;
        int[][] dp=new int[m+10][n+10];
        for (int i = 0; i <= m; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]+=dp[i-1][j];
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]+=dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
