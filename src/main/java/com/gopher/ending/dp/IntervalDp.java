package com.gopher.ending.dp;

import java.util.Scanner;

/**
 * @Title IntervalDp
 * @Author fyw
 * @Date 2022/3/14 23:09
 * @Description: 区间DP
 */
public class IntervalDp {
    static class CodeWing1{
        // 石子合并
        /**
         * f[i,j]表示所有将[i~j]合并成一堆的可能情况中代价最小的方案
         * 分类情况，左侧可能包含i、i+1、i+2、...、j-1堆。
         *
         * 区间DP：
         * for (int len = 1; len <= n; len++) {         // 区间长度
         *     for (int i = 1; i + len - 1 <= n; i++) { // 枚举起点
         *         int j = i + len - 1;                 // 区间终点
         *         if (len == 1) {
         *             dp[i][j] = 初始值
         *             continue;
         *         }
         *
         *         for (int k = i; k < j; k++) {        // 枚举分割点，构造状态转移方程
         *             dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + w[i][j]);
         *         }
         *     }
         * }
         */
        static int N=305;
        static int[][] f=new int[N][N]; // 状态转移
        static int[] sum=new int[N]; // 前缀和

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            for (int i = 1; i<=n ; i++) {
                sum[i]=sum[i-1]+scanner.nextInt();
            }
            // 进行状态转移
            for (int len = 2; len <= n; len++) {
                for (int i = 1; i+len-1 <=n ; i++) {
                    int j=i+len-1;
                    f[i][j]=Integer.MAX_VALUE;  // 每一个值都设置无穷大
                    for (int k = i; k < j; k++) {
                        f[i][j]=Math.min(f[i][j],f[i][k]+f[k+1][j]+sum[j]-sum[i-1]);
                    }
                }
            }
            System.out.println(f[1][n]);
        }
    }
    static class CodeWing2{

    }
}
