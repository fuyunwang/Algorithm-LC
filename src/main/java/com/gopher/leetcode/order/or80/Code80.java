package com.gopher.leetcode.order.or80;

/**
 * @Title Code80
 * @Author fyw
 * @Date 2022/2/9 14:47
 * @Description: 删除有序数组中的重复项 II
 */
public class Code80 {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if (i<2||nums[i]!=nums[index-2])
                nums[index++]=nums[i];
        }
        return index;
    }
}
