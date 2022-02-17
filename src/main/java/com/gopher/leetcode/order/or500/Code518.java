package com.gopher.leetcode.order.or500;

/**
 * @Title Code518
 * @Author fyw
 * @Date 2022/2/9 13:59
 * @Description: 零钱兑换
 * dp、类似完全背包
 */
public class Code518 {
    //f[i, j]表示从前i个物品选，且总体积恰好是j的总方案数
    public int change(int amount, int[] coins) {
        int[] f=new int[amount+10];
        f[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                f[j]+=f[j-coins[i]];
            }
        }
        return f[amount];
    }
}
