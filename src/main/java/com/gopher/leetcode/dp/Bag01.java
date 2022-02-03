package com.gopher.leetcode.dp;

import java.util.Scanner;

/**
 * @Title Bag01
 * @Author fyw
 * @Date 2022/2/2 21:22
 * @Description: 01背包问题
 * 定义f[i][j]为只看前i个物品并且总体积是j的情况下，总价值最大为多少
 *
 * f[i][j]：
 * 1. 不选第i个物品的情况下：f[i][j]=f[i-1][j]
 * 2. 选第i个物品：f[i][j]=f[i-1][j-v[i]] + w[i]
 *
 * f[i][j]=max{1,2}
 *
 * f[0][0]=0
 */
public class Bag01 {
    static int N = 1010;
    static int f[][] = new int[N][N];
    static int w[] = new int[N];
    static int v[] = new int[N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //表示物品个数
        int m = scanner.nextInt();  //表示可用的背包容量
        for (int i = 1; i <= n; i++) { //记录每个物品的价值与背包容量
            int k = scanner.nextInt();
            int a = scanner.nextInt();
            v[i] = k;
            w[i] = a;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j]=f[i-1][j];
                if (j>=v[i])    // 判断当前的容量能否容纳当前的体积
                    f[i][j]=Math.max(f[i][j],f[i-1][j-v[i]]+w[i]);
            }
        }
        System.out.println(f[n][m]);//得到
    }
}
