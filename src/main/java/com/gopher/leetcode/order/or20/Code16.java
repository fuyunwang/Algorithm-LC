package com.gopher.leetcode.order.or20;

import java.util.Arrays;

/**
 * @Title Code16
 * @Author fyw
 * @Date 2022/1/22 15:30
 * @Description:
 */
public class Code16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0x3f3f3f3f;
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1])
                continue;
            for (int j=i+1,k=nums.length-1;j<k;){
                int sum = nums[i]+nums[j]+nums[k];
                result = Math.abs(sum-target)<Math.abs(result-target)?sum:result;
                if (sum>target){
                    k--;
                }else if (target>sum){
                    j++;
                }else{
                    return target;
                }
            }
        }
        return result;
    }
}
