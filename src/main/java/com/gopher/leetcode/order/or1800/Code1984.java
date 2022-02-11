package com.gopher.leetcode.order.or1800;

import java.util.Arrays;

/**
 * @Title Code1984
 * @Author fyw
 * @Date 2022/2/11 17:51
 * @Description: 固定大小的滑动窗口
 */
public class Code1984 {
    public int minimumDifference(int[] nums, int k) {
        int res=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int l=0,r=k-1; r < nums.length;) {
            res=Math.min(res,nums[r++]-nums[l++]);
        }
        return res;
    }
}
