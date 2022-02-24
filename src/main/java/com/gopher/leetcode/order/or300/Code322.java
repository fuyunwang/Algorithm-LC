package com.gopher.leetcode.order.or300;

/**
 * @Title Code322
 * @Author fyw
 * @Date 2022/2/9 12:39
 * @Description: 零钱兑换
 */
public class Code322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++){
            dp[i] = amount + 1;
        }

        for (int c: coins){
            for (int j = c; j <= amount; j++){
                dp[j] = Math.min(dp[j], dp[j - c] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
