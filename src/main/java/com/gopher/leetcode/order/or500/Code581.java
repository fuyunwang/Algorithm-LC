package com.gopher.leetcode.order.or500;

/**
 * @Title Code581
 * @Author fyw
 * @Date 2022/2/13 21:55
 * @Description: 最短无序连续子数组
 * 从左半部分找到小于等于右半部分元素最小值的最大值
 */
public class Code581 {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < nums.length && nums[l + 1] > nums[l]) l++;
        if (l == r) return 0;
        // 此时l记录在左半部分最右的点

        while (r - 1 >= 0 && nums[r - 1] <= nums[r]) r--;
        // 此时r记录在有半部分最右的点

        // 枚举左半部分找到严格小的点
        for (int i = l + 1; i < nums.length; i++) {
            while (l >= 0 && nums[l] > nums[i]) {
                l--;
            }
        }

        // 枚举右半部分找到严格大的点
        for (int i = r - 1; i >= 0; i--) {
            while (r < nums.length && nums[r] < nums[i]) {
                r++;
            }
        }

        return Math.max(r - l - 1, 0);
    }
}
