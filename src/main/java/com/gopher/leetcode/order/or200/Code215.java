package com.gopher.leetcode.order.or200;

/**
 * @Title Code215
 * @Author fyw
 * @Date 2022/2/3 20:01
 * @Description: 数组中的第K个最大元素，快速排序
 */
public class Code215 {


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
