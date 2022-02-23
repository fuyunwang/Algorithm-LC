package com.gopher.leetcode.order.or120;

/**
 * @Title Code154
 * @Author fyw
 * @Date 2022-02-23 19:27
 * @Description 寻找旋转排序数组中的最小值
 * 含有重复元素
 */
public class Code154 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r && nums[r] == nums[0]) r --;
        if(l == r) return nums[0];
        while(l < r)
        {
            int mid = l + r >> 1;
            if(nums[r] >= nums[mid]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
