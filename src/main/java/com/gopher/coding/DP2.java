package com.gopher.coding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Title DP2
 * @Author fyw
 * @Date 2022-02-21 18:53
 * @Description 线性DP、区间DP、计数类DP
 */
public class DP2 {
    static class Code1{
        // 数字三角形

    }
    static class Code2{
        // 最长上升子序列
        static class Code2_1{
            // 状态表示: f[i]表示所有以第i个数结尾的上升子序列的集合，属性是子序列长度最大值
            // 状态计算：分类讨论：
            // 1. 考虑倒数第二位数字，如果是aj f[i]=f[j]+1. 注意这里有条件aj<ai
            static Scanner in = new Scanner(System.in);
            static int N = 1010;
            static int a[] = new int[N], f[] = new int[N];

            public static void main(String args[]) {
                int n = in.nextInt();
                for (int i = 1; i <= n; i++) a[i] = in.nextInt();
                // dp
                int max = 0;
                for (int i = 1; i <= n; i++) {
                    f[i] = 1;
                    for (int j = 1; j < i; j++) {
                        if (a[j] < a[i])
                            f[i] = MathTemplate.max(f[i], f[j] + 1);
                    }
                    max = MathTemplate.max(max, f[i]);
                }
                System.out.println(max);
            }
        }
        static class Code2_2{
            // 最长上升公共子序列
            static int N = 3010;
            static int[] a = new int[N];
            static int[] b = new int[N];
            static int[][] f = new int[N][N];
            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                int n = scan.nextInt();
                for(int i = 1;i <= n;i ++) a[i] = scan.nextInt();
                for(int i = 1;i <= n;i ++) b[i] = scan.nextInt();
                for(int i = 1;i <= n;i ++) {
                    for(int j = 1;j <= n;j ++) {
                        f[i][j] = f[i - 1][j];
                        if(a[i] == b[j])
                        {
                            f[i][j] = 1;//初始为1
                            for(int k = 1;k < j;k ++)
                            {
                                if(b[k] < b[j]) f[i][j] = MathTemplate.max(f[i][j], f[i - 1][k] + 1);
                            }
                        }
                    }
                }
                //需要类似最长上升子序列求得最大值,也可以直接加到上面的循环中
                int res = 0;
                for(int i = 1;i <= n;i ++) res = MathTemplate.max(res,f[n][i]);
                System.out.println(res);
            }
        }
    }
    static class Code3{
        // 最长公共子序列
        // 状态表示: f[i,j]表示所有a[1~i]和b[1~j]的公共子序列的集合，属性是最长的子序列
        // 状态计算：分类讨论：
        // 1. 同时包含ai和bj，f[i,j]=f[i-1,j-1]+1。 注意这里有条件a.charAt(i) == b.charAt(j)
        // 2. 同时不包含ai和bj，f[i,j]=f[i-1,j-1]
        // 3. f[i-1,j]表示确定不含ai但不保证一定含bj，其也包含了2。最值可以重复。
        // 4. f[i,j-1]同3的分析方式
        public static void main(String[] args) {
            // 初始化注意保证从1开始所以前面加一个空格字符
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int m = scan.nextInt();
            String A = " " + scan.next();
            String B = " " + scan.next();
            // dp
            int[][] f = new int[n + 10][m + 10];
            for(int i = 1;i <= n;i++) {
                for(int j = 1;j <= m;j++) {
                    f[i][j] = MathTemplate.max(f[i-1][j], f[i][j - 1]);
                    //包含A[i] = B[j]情况的集合
                    if(A.charAt(i) == B.charAt(j))
                        f[i][j] = MathTemplate.max(f[i][j],f[i - 1][j - 1] + 1);
                }
            }
            System.out.println(f[n][m]);

        }
    }
    static class Code4{
        // 编辑距离
        static class Code1{
            // 最短编辑距离
            // 状态表示: f[i,j]表示所有将a[1~i]变成b[1~j]的操作方式的集合，属性表示操作数的最小值。
            // 状态计算：分类讨论：
                      // 1. 删除 ai ，此时需要 a[1~i-1]==b[1~j]。f[i,j]=f[i-1,j]+1
                      // 2. 增加 ai ，此时需要 a[1~i]==b[1~j-1]。 f[i,j]=f[i,j-1]+1
                      // 3. 修改 ai ，此时需要 a[1~i-1]==b[1~j-1]。 f[i,j]=f[i-1,j-1]+1。注意这里有条件a.charAt(i) == b.charAt(j)
            static int N = 1010;
            static int[][] f = new int[N][N];
            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                int n = scan.nextInt();
                String a = " " + scan.next();
                int m = scan.nextInt();
                String b = " " + scan.next();
                // 线性DP
                for(int i = 0;i <= m;i++) f[0][i] = i;//若a长度为0，b长度为i，则需要进行i次添加操作
                for(int i = 0;i <= n;i++) f[i][0] = i;//若a长度为i，b长度为0，则需要进行i次删除操作
                for(int i = 1;i <= n;i++)
                    for(int j = 1;j <= m;j++)
                    {   //删除和添加
                        f[i][j] = MathTemplate.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                        //修改
                        if(a.charAt(i) == b.charAt(j)) f[i][j] = MathTemplate.min(f[i][j], f[i - 1][j - 1]);
                        else f[i][j] = MathTemplate.min(f[i][j], f[i - 1][j - 1] + 1);
                    }
                System.out.println(f[n][m]);
            }
        }
    }
    static class Code5{
        // 区间DP 石子合并，在哈弗曼树的基础上每次只能合并相邻两堆
        // 状态表示: f[i,j]表示所有将[i,j]区间内的石子合并成一堆的方案集合，属性代价最小值
        // 状态计算：分类讨论：
                // 通式情况是 左边有[i,k]右边有[k+1,j]。注意k的枚举范围
                // 区间DP首先枚举长度，根据题意最小长度是2
        static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        public static void main(String[] args) throws Exception{
            // 初始化
            int n = Integer.valueOf(read.readLine());
            String[] ss = read.readLine().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = Integer.valueOf(ss[i]);
            }
            // 计算前缀和
            int[] sum = new int[n + 1];
            for(int i = 1; i <= n; i++){
                sum[i] = sum[i - 1] + a[i - 1];
            }
            //dp
            int[][] dp = new int[n + 1][n + 1];
            for(int len = 2; len <= n; len++){
                for(int l = 1; l + len - 1 <= n; l++){
                    int r = l + len - 1;
                    dp[l][r] = 0x3f3f3f3f;   //初始化
                    for(int k = l; k < r; k++){
                        dp[l][r] = MathTemplate.min(dp[l][r],
                                dp[l][k] + dp[k + 1][r] + sum[r] - sum[l - 1]);

                    }
                }
            }
            System.out.println(dp[1][n]);
        }
    }
    static class Code6{
        // 计数类DP 整数划分
        // 给定正整数n划分成多个正整数之和，其中不考虑顺序

    }
}
