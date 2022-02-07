package com.gopher.leetcode.order.or500;

import java.util.Arrays;

/**
 * @Title Code561
 * @Author fyw
 * @Date 2022/2/7 13:27
 * @Description:
 * 贪心，两两配对之后的组中的最小值的和最大值
 */
public class Code561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}
