package com.gopher.leetcode.order.or120;

/**
 * @Title Code152
 * @Author fyw
 * @Date 2022/2/8 21:24
 * @Description: 乘积最大的子数组
 * 找出数组中乘积最大的非空连续子数组
 */
public class Code152 {
    // f[i-1]表示以i-1结尾的连续子数组的乘积最大值，处理正数
    // g[i-1]表示以i-1结尾的连续子数组的乘积最小值，处理负数
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int f = nums[0], g = nums[0];
        for(int i = 1;i < nums.length;i ++)
        {
            int a = nums[i], fa = f * a, ga = g * a;
            f = Math.max(a, Math.max(fa, ga));
            g = Math.min(a, Math.min(fa, ga));
            res = Math.max(res, f);
        }
        return res;
    }
}
