package com.gopher.leetcode.order.or400;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code442
 * @Author fyw
 * @Date 2022/2/8 21:57
 * @Description: 数组中重复的数据
 * Code448
 */
public class Code442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int X = Math.abs(nums[i]);
            if (nums[X - 1] > 0) {
                nums[X - 1] *= -1;
            } else {
                res.add(X);
            }
        }
        return res;
    }
}
