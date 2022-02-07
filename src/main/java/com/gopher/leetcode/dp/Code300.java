package com.gopher.leetcode.dp;

import java.util.Arrays;

/**
 * @Title Code300
 * @Author fyw
 * @Date 2022/2/7 14:59
 * @Description: 最长递增子序列
 * dp[i] 表示以i位置元素结尾时的最长递增子序列长度
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
