package com.gopher.swordoffer;

/**
 * @Title SwordOffer03
 * @Author fyw
 * @Date 2022/2/8 21:32
 * @Description: 数组中重复的数字
 * 计数排序
 */
public class SwordOffer03 {
    public int findRepeatNumber(int[] nums) {
        int[] ans=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[nums[i]]++;
            if (ans[nums[i]]>1){
                return nums[i];
            }
        }
        return -1;
    }
}
