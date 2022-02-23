package com.gopher.leetcode.order.or120;

/**
 * @Title Code15
 * @Author fyw
 * @Date 2022-02-23 19:26
 * @Description 寻找旋转排序数组中的最小值
 */
public class Code153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(nums[r] > nums[mid] ) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
