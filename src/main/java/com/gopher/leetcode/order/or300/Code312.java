package com.gopher.leetcode.order.or300;

import java.util.Arrays;

/**
 * @Title Code312
 * @Author fyw
 * @Date 2022/2/9 13:51
 * @Description: 戳气球
 * 字节笔试，dp
 * 枚举每一个值，从中间考虑两侧，有点类似洗衣机
 * f[i,j]表示将[i+1,j-1]打完的所有方案，注意边界不被打掉才能算，边界补1并且不被打掉
 *
 */
public class Code312 {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] a=new int[n+2];
        Arrays.fill(a,1);
        for (int i = 1; i <= n; i++) {
            a[i]=nums[i-1];
        }

        int[][] f=new int[n+2][n+2];
        for (int len = 3; len <= n+2; len++) {  // 长度最小是3，否则不存在左右边界
            // 枚举可能的左右边界
            for (int i = 0; i+len-1 < n+2; i++) {
                int j = i + len - 1;
                // 从中间元素开始枚举两侧
                for (int k = i+1; k < j; k++) {
                    f[i][j]=Math.max(f[i][j],f[i][k]+f[k][j]+a[i]*a[k]*a[j]);
                }
            }
        }
        return f[0][n+1]; //得到除了两侧边界之外，中间气球戳完的最大值
    }
}
