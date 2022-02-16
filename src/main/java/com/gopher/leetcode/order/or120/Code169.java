package com.gopher.leetcode.order.or120;

import java.util.Arrays;

/**
 * @Title Code169
 * @Author fyw
 * @Date 2022/2/8 21:12
 * @Description: 多数元素
 */
public class Code169 {
    public int majorityElement(int[] nums) {
        int r = 0,c = 0;
        for(int i = 0;i < nums.length;i ++)
        {
            int x = nums[i];
            if(c == 0) {r = x; c = 1;}
            else if(r == x) c ++;
            else c --;
        }

        return r;
    }
}
