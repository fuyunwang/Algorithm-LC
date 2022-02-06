package com.gopher.leetcode.order.or30;

/**
 * @Title Code26
 * @Author fyw
 * @Date 2022/1/23 17:12
 * @Description:
 */
public class Code26 {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
