package com.gopher.leetcode.order.or200;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title Code217
 * @Author fyw
 * @Date 2022/2/3 19:27
 * @Description: 存在重复元素
 */
public class Code217 {
    // set在添加时如果存在重复元素直接返回false
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
