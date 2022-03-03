package com.gopher.leetcode.types.array;

/**
 * @Title Template3
 * @Author fyw
 * @Date 2022-03-03 20:41
 * @Description 计数排序
 */
public class Template3 {
    public int[] buildArray(int[] nums) {
        int[] res=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i]=nums[nums[i]];
        }
        return res;
    }
}
