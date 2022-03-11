package com.gopher.leetcode.types.array;

import java.util.Arrays;

/**
 * @Title Others
 * @Author fyw
 * @Date 2022-03-11 15:21
 * @Description
 */
public class Others {
    static class Code910{
        // 枚举数组的分界点，必然是某个分界线的左侧全加右侧全减
        public int smallestRangeII(int[] nums, int k) {
            Arrays.sort(nums);
            int res=nums[nums.length-1]-nums[0];
            for (int i = 0; i < nums.length-1; i++) {
                int max=Math.max(nums[i]+k,nums[nums.length-1]-k);
                int min=Math.min(nums[0]+k,nums[i+1]-k);
                res=Math.min(res,max-min);
            }
            return res;
        }
    }
}
