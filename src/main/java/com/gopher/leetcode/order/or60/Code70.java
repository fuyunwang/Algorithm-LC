package com.gopher.leetcode.order.or60;

/**
 * @Title Code70
 * @Author fyw
 * @Date 2022/2/3 19:38
 * @Description: 爬楼梯
 */
public class Code70 {
    public int climbStairs(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
