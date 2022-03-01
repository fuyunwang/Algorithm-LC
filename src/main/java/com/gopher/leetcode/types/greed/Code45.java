package com.gopher.leetcode.types.greed;

/**
 * @Title Code45
 * @Author fyw
 * @Date 2022/1/29 22:00
 * @Description: 跳跃游戏
 */
public class Code45 {
    public int jump(int[] nums) {
        int step=0;
        int max=0;
        int end=0;// 记录能跳的最远位置
        for (int i = 0; i < nums.length-1; i++) {
            max=Math.max(max,i+nums[i]);
            if (i==end){ //当前已经来到最右的位置了，更新并进行跳跃
                end=max;
                step++;
            }
        }
        return step;
    }
}
