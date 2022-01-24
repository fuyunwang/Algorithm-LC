package com.gopher.leetcode;

/**
 * @Title Code27
 * @Author fyw
 * @Date 2022/1/23 17:28
 * @Description:
 */
public class Code27 {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
