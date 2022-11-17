package com.gopher.leetcode.order.or600;

/**
 * @Title Code674
 * @Author fyw
 * @Date 2022/11/17 20:25
 * @Description 最长连续递增序列
 */
public class Code674 {
    public int findLengthOfLCIS(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            int j=i+1;
            while (j<nums.length&&nums[j]>nums[j-1])
                j++;
            res=Math.max(res,j-i);
            i=j-1;
        }
        return res;
    }
}
