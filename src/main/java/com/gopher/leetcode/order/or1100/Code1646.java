package com.gopher.leetcode.order.or1100;

import java.util.Arrays;

/**
 * @Title Code1646
 * @Author fyw
 * @Date 2022/2/9 14:03
 * @Description:
 */
public class Code1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; ++i) {
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
