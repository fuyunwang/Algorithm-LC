package com.gopher.leetcode;

/**
 * @Title Code136
 * @Author fyw
 * @Date 2022/1/31 17:48
 * @Description: 题目要求只有一个元素出现一次其他的都出现两次，同时出现两次的元素异或结果为0
 */
public class Code136 {
    public int singleNumber(int[] nums) {
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }
}
