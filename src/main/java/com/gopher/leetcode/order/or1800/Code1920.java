package com.gopher.leetcode.order.or1800;

/**
 * @Title Code1920
 * @Author fyw
 * @Date 2022/2/9 14:40
 * @Description:
 */
public class Code1920 {
    public int[] buildArray(int[] nums) {
        int[] res=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i]=nums[nums[i]];
        }
        return res;
    }
}
