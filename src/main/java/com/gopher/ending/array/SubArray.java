package com.gopher.ending.array;

/**
 * @Title SubArray
 * @Author fyw
 * @Date 2022/3/12 20:22
 * @Description: 子数组
 */
public class SubArray {
    static class Code713{
        // 乘积小于K的子数组，双指针
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int res=0,p=1;
            for (int i = 0,left=0; i < nums.length; i++) {
                p*=nums[i];
                while (left<=i&&p>=k) p/=nums[left++];
                res+=i-left+1;
            }
            return res;
        }
    }
}
