package com.gopher.leetcode.types.greed;

/**
 * @Title Code55
 * @Author fyw
 * @Date 2022/1/29 22:01
 * @Description: 跳跃游戏
 */
public class Code55 {
    public boolean canJump(int[] nums) {
        int end=0;
        for (int i = 0; i < nums.length; i++) {
            if (end<i) return false;// 说明跳不过去
            end=Math.max(end,i+nums[i]);
        }
        return true;
    }
}
