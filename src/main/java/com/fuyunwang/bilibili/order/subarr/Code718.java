package com.fuyunwang.bilibili.order.subarr;

/**
 * @Title Code718
 * @Author fyw
 * @Date 2022-05-25 9:08
 * @Description 最长重复子数组，返回重复的最长子数组的长度
 * DP
 */
public class Code718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n+10][m+10];
        int res=0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
