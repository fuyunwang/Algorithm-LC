package com.gopher.leetcode.order.or700;

/**
 * @Title Code746
 * @Author fyw
 * @Date 2022/2/9 14:10
 * @Description: 使用最小花费爬楼梯
 */
public class Code746 {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}
