package com.gopher.leetcode.order.or300;

import java.util.Arrays;

/**
 * @Title Code300
 * @Author fyw
 * @Date 2022/2/8 21:12
 * @Description: 最长递增子序列
 * 求以每个元素结尾的最长递增子序列的长度，取最大值
 */
public class Code300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int res=0;
        for(int i=0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
