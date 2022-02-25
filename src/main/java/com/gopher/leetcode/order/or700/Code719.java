package com.gopher.leetcode.order.or700;

import java.util.Arrays;

/**
 * @Title Code719
 * @Author fyw
 * @Date 2022/2/9 14:02
 * @Description:
 */
public class Code719 {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int r = nums[n - 1] - nums[0] + 1;

        while (l < r) {
            int m = l + ((r - l)>>1);

            int count = 0;
            int j = 0;
            for (int i = 1; i < n; i++) {
                while (j < i && nums[i] - nums[j] > m) {
                    j++;
                }
                count += i - j;
            }

            if (count >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
