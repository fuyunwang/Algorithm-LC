package com.gopher.leetcode;

/**
 * @Title Code334
 * @Author fyw
 * @Date 2022/1/30 19:44
 * @Description: 递增的三元子序列，类似Code747的双百做法，记录最大值和次大值
 */
public class Code334 {
    public boolean increasingTriplet(int[] nums) {
        int a=Integer.MAX_VALUE,b=a;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=a){
                a=nums[i];
            }else if (nums[i]<=b){
                b=nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}
