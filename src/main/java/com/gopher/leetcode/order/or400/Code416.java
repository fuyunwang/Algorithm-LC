package com.gopher.leetcode.order.or400;

/**
 * @Title Code416
 * @Author fyw
 * @Date 2022/2/9 12:29
 * @Description: 分割等和子集
 * n个元素，背包容量sum/2，求是否能够恰好装满背包
 */
public class Code416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length ;
        int sum = 0 ;
        for (int i = 0;  i < n ; ++i) {
            sum += nums[i] ;
        }
        if (sum % 2 != 0) return false ;
        int t = sum / 2 ;
        boolean [][] f = new boolean [n + 1][t + 1];
        f[0][0] = true ;
        for (int i = 1 ; i <= n ; ++i) {
            for (int j = 0 ; j <= t ; ++j) {
                f[i][j] = f[i - 1][j] ;
                if (j >= nums[i - 1] && !f[i][j]) {
                    f[i][j] = f[i - 1][j - nums[i - 1]];
                }

            }
        }

        return f[n][t] ;
    }

}
