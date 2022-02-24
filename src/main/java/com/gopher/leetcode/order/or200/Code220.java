package com.gopher.leetcode.order.or200;

import java.util.HashSet;

/**
 * @Title Code220
 * @Author fyw
 * @Date 2022/2/9 17:52
 * @Description: 存在重复元素
 */
public class Code220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashSet<Long> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (Long value:set){
                if (Math.abs(value-nums[i])<=t)
                    return true;
            }
            set.add((long) nums[i]);
            if (set.size()>k){
                set.remove((long) nums[i-k]);
            }
        }
        return false;
    }
}
