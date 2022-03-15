package com.gopher.ending.dp;

import java.util.Scanner;

/**
 * @Title CountingDP
 * @Author fyw
 * @Date 2022-03-15 14:53
 * @Description 计数类DP
 */
public class CountingDP {
    static class CodeWing1{
        // 整数划分
        /**
         * f[i][j]表示从1到i中选，体积恰好是j的方案数
         */
        static int N=1010;
        static int[] f=new int[N];
        static int MOD= (int) 1e9 + 7;
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            f[0]=1; // 体积是0有一种方案，完全背包从小到大枚举
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    f[j]=(f[j]+f[j-i])%MOD;
                }
            }
            System.out.println(f[n]);
        }
    }
}
