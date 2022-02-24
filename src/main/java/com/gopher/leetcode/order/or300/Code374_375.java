package com.gopher.leetcode.order.or300;

/**
 * @Title Code375
 * @Author fyw
 * @Date 2022/2/9 13:50
 * @Description:
 */
public class Code374_375 {
    // Code375 类似戳气球，鸡蛋的硬度
    // 区间DP
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int [][] f = new int [n + 1][n + 1];
        for (int len = 2; len <= n ; ++len) {
            for (int l = 1 ; l + len - 1 <= n ; ++l) {
                int r = l + len - 1 ;
                f[l][r] = Integer.MAX_VALUE;
                for (int k = l ; k < r ; ++k) {
                    f[l][r] = Math.min(f[l][r], Math.max(f[l][k - 1], f[k + 1][r]) +  k) ;
                }
            }
        }
        return f[1][n] ;
    }
}
