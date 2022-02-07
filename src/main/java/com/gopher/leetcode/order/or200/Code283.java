package com.gopher.leetcode.order.or200;

/**
 * @Title Code283
 * @Author fyw
 * @Date 2022/1/30 19:59
 * @Description:
 */
public class Code283 {
    public void moveZeroes(int[] nums) {
        int index=0;    // 主要就是针对index进行改变
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0)
                nums[index++]=nums[i];
        }
        for (int i=index;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
