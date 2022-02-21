package com.gopher.coding;

import java.util.Scanner;

/**
 * @Title DP1
 * @Author fyw
 * @Date 2022-02-21 18:53
 * @Description 背包
 */
public class DP1 {
    static class Code1{
        // 0-1 背包。一个物品只能选一个或者不选
        // f[i,j]表示只从前i个物品选并且总体积小于等于j的最大价值的物品集合

        /**
         * 递归思路：求f(N,V)
         * f(i,j) = max(f(i-1,j),f(i-1,j-v[i])+w[i])
         * 当在取第i件物品时，拿或不拿，取个最大值
         */
        static int N = 1010;
        static int f[][] = new int[N][N];
        static int w[] = new int[N];
        static int v[] = new int[N];
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();  // 物品个数
            int m = scanner.nextInt();  // 背包容量
            for(int i = 1 ; i <= n ; i ++) {
                int k = scanner.nextInt();
                int a = scanner.nextInt();
                v[i] = k;
                w[i] = a;
            }

            for(int i = 1; i <= n ; i++) {
                for(int j = 0;j <= m ; j ++) {
                    f[i][j] = f[i-1][j];
                    if(j>=v[i]){
                        f[i][j] = Math.max(f[i][j], f[i-1][j-v[i]]+w[i]);
                    }
                }
            }
            System.out.println(f[n][m]);
        }
    }
    static class Code2{
        // 完全背包。每件物品可以取无限次
        // f[i,j] 从前i个物品选并且总体积小于等于j的最大价值的物品集合
        // 优化过程就是LeetCode第10题

        /**
         * 完全背包：朴素版
         * 递归思想：f(N,M) 转化到下一个状态是：
         *      f(i,j) = Math.max(f(i-1,j),f(i-1,j-1v[i])+w,f(i-1,j-2v[i])+2w...f(i-1,j-kv[i])+kw)
         * 优化推导
         *      f(i,j-v[i]) = Math.max(f(i-1,j-1v[i]),f(i-1,j-2v[i])+w,f(i-1,j-3v[i])+2w...f(i-1,j-(k+1)v[i])+kw)
         *      注意：j-kv[i]已经到了极限，那么j-(k+1)v[i]一定小于0,不符合题意不予计算
         *      所以：f(i,j)  = Math.max(f(i-1,j),f(i,j-v[i])+w)
         *      此处的f(i,j-v[i])+w，使用的是本行更新过的状态，从小到大枚举体积
         */
        static int N = 1010;
        static int f[] = new int[N];
        static int w[] = new int[N];
        static int v[] = new int[N];
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for(int i = 1; i <= n; i++) {
                int k = scanner.nextInt();
                int a = scanner.nextInt();
                v[i] = k;
                w[i] = a;
            }
            for(int i = 1; i <= n; i++) {
                for(int j = v[i];j <= m;j ++) {
                    f[j] = Math.max(f[j], f[j-v[i]]+w[i]);
                }
            }
            System.out.println(f[m]);
        }
    }
    static class Code3{
        // 多重背包。每个物品有对应的数量，有对应的限制

    }
    static class Code4{
        // 多重背包优化

    }
    static class Code5{
        // 分组背包。每一组只能选一个

    }
    static class Code6{
        // 混合背包
    }
    static class Code7{
        // 二维费用的背包问题
    }
    static class Code8{
        // 背包问题求方案数
    }
    static class Code9{
        // 求背包问题的方案
    }
    static class Code10{
        // 有依赖的背包问题
    }
}
