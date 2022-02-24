package com.gopher.leetcode.order.or200;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Title Code220
 * @Author fyw
 * @Date 2022/2/9 17:52
 * @Description: 存在重复元素III
 * 找到最接近x的数等价于找到大于等于x最小数和小于等于x最大数
 */
public class Code220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if(n < 2) return false;
        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0;i < n;i ++) {
            Long e = (long)nums[i];
            Long l = set.floor(e);//窗口中小于等于e的最大值
            Long r = set.ceiling(e);//窗口中大于等于e的最小值
            if(l != null && e - l <= t) return true;
            if(r != null && r - e <= t) return true;
            set.add(e);
            if(set.size() > k) set.remove((long)nums[i - k]);
        }
        return false;
    }
}
