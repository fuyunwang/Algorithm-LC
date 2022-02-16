package com.gopher.leetcode.order.or300;

/**
 * @Title Code303
 * @Author fyw
 * @Date 2022/2/16 19:57
 * @Description: 区域和检索
 * 一维前缀和
 */
public class Code303 {
    class NumArray {
        int[] s ;
        public NumArray(int[] nums) {
            s = new int[nums.length+1];
            if(nums.length != 0){

                for(int i =1;i<nums.length+1;i++){
                    s[i] = nums[i-1]+s[i-1];
                }
            }
        }
        public int sumRange(int i, int j) {
            return s[j+1]-s[i];
        }
    }
}
