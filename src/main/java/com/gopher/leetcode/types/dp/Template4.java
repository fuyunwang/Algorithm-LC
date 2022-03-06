package com.gopher.leetcode.types.dp;

import java.util.Arrays;

/**
 * @Title Template4
 * @Author fyw
 * @Date 2022-03-05 20:26
 * @Description 背包DP
 */
public class Template4 {
    static class Code1049{
        //  最后一块石头的重量 II
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length, sum = 0, m;
            for(int stone : stones) sum += stone;
            m = sum/2;


            int[] f = new int[m+1];
            for (int i = 0; i < n; i++) {
                for (int j = m; j >= stones[i]; j--) {
                    f[j] = Math.max(f[j], f[j-stones[i]] + stones[i]);
                }
            }

            return Math.abs(sum - 2 * f[m]);
        }
    }
}
