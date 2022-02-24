package com.gopher.leetcode.order.or200;

import java.util.HashSet;

/**
 * @Title Code219
 * @Author fyw
 * @Date 2022-02-24 8:16
 * @Description 存在重复元素II
 */
public class Code219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);// 移除对应索引下的元素，set作为滑动窗口，
            }
        }
        return false;
    }
}
