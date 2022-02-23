package com.gopher.leetcode.order.or200;

/**
 * @Title Code209
 * @Author fyw
 * @Date 2022/2/9 13:49
 * @Description: 长度最小的子数组
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1,..., numsr-1, numsr]
 * 滑动窗口
 */
public class Code209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int result=nums.length+1;
        int sum=0;

        for (;left<nums.length;){
            if (right<nums.length&&sum<target){
                sum+=nums[right++];
            }else {
                sum-=nums[left++];
            }
            if(sum>=target){
                result=Math.min(result,right-left);
            }
        }

        return result==nums.length+1?0:result;
    }
}
