package com.fuyunwang.bilibili.order.subseq;

/**
 * @Title Code516
 * @Author fyw
 * @Date 2022-05-26 15:40
 * @Description 最长回文子序列
 * 区间dp
 */
public class Code516 {
    /**
     * f[i,j]表示所有s[i~j]中回文子序列的长度最大值
     */
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        s=" "+s;
        int[][] dp=new int[n+10][n+10];
        // 区间dp首先枚举长度
        for (int len = 1; len <= n ; len++) {
            for (int i = 1; i+len-1 <=n ; i++) {    // 枚举开始索引
                int j=i+len-1;// 确定结束索引
                if (len==1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    if (s.charAt(i)==s.charAt(j)){
                        dp[i][j]=Math.max(dp[i][j],dp[i+1][j-1]+2);
                    }
                }
            }
        }
        return dp[1][n];
    }
}
