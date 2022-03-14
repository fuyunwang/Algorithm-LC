package com.gopher.ending.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Title PathDp
 * @Author fyw
 * @Date 2022/3/14 20:13
 * @Description: 路线型DP
 */
public class PathDp {
    static class CodeWing1 {
        // 数字三角形
        static int N=505;
        static int[][] a=new int[N][N];

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    a[i][j]=scanner.nextInt();
                }
            }
            // 进行状态计算
            for (int i = n-1; i >=1 ; i--) {
                for (int j = 1; j <= i; j++) {
                    a[i][j]+=Math.max(a[i+1][j],a[i+1][j+1]);
                }
            }
            System.out.println(a[1][1]);
        }
    }

    static class CodeWing2 {
        // 摘花生
        /**
         * f[i,j]表示从[1,1]走到[i,j]的所有路线中能取到花生数的最大值。
         * 状态计算考虑最后一个位置可以从[i-1,j]或者[i,j-1]转移过来
         */
        static int N = 110;
        static int[][] f = new int[N][N];

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(reader.readLine().trim());
            while (T-- > 0) {
                // 首先读入行和列
                String[] str = reader.readLine().trim().split(" ");
                int r = Integer.parseInt(str[0]);
                int c = Integer.parseInt(str[1]);
                for (int i = 1; i <= r; i++) {
                    str = reader.readLine().trim().split(" ");
                    for (int j = 1; j <= c; j++) {
                        f[i][j] = Integer.parseInt(str[j - 1]);
                    }
                }
                // 进行状态转移计算
                for (int i = 1; i <= r; i++) {
                    for (int j = 1; j <= c; j++) {
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + f[i][j];
                    }
                }
                System.out.println(f[r][c]);
            }
        }
    }

    static class CodeWing3 {
        // 最低通行费，多了一个限制必须在2n-1内走到(其实本质还是不能走回头路)，求最小值
        // 本质还是求矩阵中一条路线权值之和的最小值
        static int N = 110;
        static int[][] f = new int[N][N];

        public static void main(String[] args) throws IOException {
//            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[][] g = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
//                final String[] split = reader.readLine().trim().split(" ");
                for (int j = 1; j <= n; j++) {
                    g[i][j] = scanner.nextInt();
                }
            }
            // 进行状态转移计算，注意求最小值需要特判
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == 1 && j == 1) f[i][j] = g[i][j];
                    else {
                        f[i][j] = Integer.MAX_VALUE;
                        if (i > 1)
                            f[i][j] = Math.min(f[i][j], f[i - 1][j] + g[i][j]);
                        if (j > 1) {
                            f[i][j] = Math.min(f[i][j], f[i][j - 1] + g[i][j]);
                        }
                    }
                }
            }
            System.out.println(f[n][n]);
        }
    }

    static class CodeWing4 {
        // 方格取数
        // 还是从左上角走到右下角，不过是走两次，而且走过一次的格子不能再走
        /**
         * f[k,i1,i2]表示所有从(1,1)走到(i1,k-i1),(i2,k-i2)的最大值。
         * 两个小朋友同时走k步,从(1,1),(1,1)走到(i1,j1),(i2,j2)能获得的最大花生数目.
         * 状态转移计算：包含四种情况，分别是两条路都向下走、两条路一条向下一条右。。。
         * k−1==i1+j1−1==i2+j2−1
         */
        // 三维DP
        static int N = 15;
        static int[][][] f = new int[N * 2][N][N];
        static int[][] g = new int[N][N];

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            while (true) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                if (a == 0 || b == 0 || c == 0)
                    break;
                g[a][b] = c;
            }
            // 进行状态转移计算，两条线和的初始值是2，终止值是2n
            for (int i = 2; i <= 2 * n; i++) {        // 枚举第一维
                for (int j = 1; j <= n; j++) {      // 枚举第二维
                    for (int k = 1; k <= n; k++) {  // 枚举第三维
                        int r1 = i - j;// 第一条线的纵坐标
                        int r2 = i - k;// 第二条线的纵坐标
                        if (r1 < 0 || r1 > n || r2 < 0 || r2 > n)
                            continue;
                        int t = g[j][r1]; // 记录当前要进入的格子
                        if (j != k) // 同步进行，不重合充要条件就是横坐标不相等
                            t += g[k][r2];    // 不相等的情况下每个要进入的格子都得计算
                        int x = f[i][j][k];
                        x = Math.max(x, f[i - 1][j - 1][k - 1] + t);
                        x = Math.max(x, f[i - 1][j - 1][k] + t);
                        x = Math.max(x, f[i - 1][j][k - 1] + t);
                        x = Math.max(x, f[i - 1][j][k] + t);
                        f[i][j][k] = x;
                    }
                }
            }
            System.out.println(f[n * 2][n][n]);
        }
    }

    static class CodeWing5 {
        // 传纸条
        static Scanner in = new Scanner(System.in);
        // 数据范围
        static int N = 51;
        // map数组: 记录方格图数字放置情况
        static int[][] g = new int[N][N];
        // dp数组: k表示移动步数 dp[k][i1][i2]表示路径一移动到i1,k-i1 路径二移动到i2,k-i2时的最大值
        static int[][][] dp = new int[2 * N][N][N];

        public static void main(String[] args) {
            int n = in.nextInt();       // n行
            int m = in.nextInt();       // m列
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= m; j++)
                    g[i][j] = in.nextInt();
            // 枚举移动步数(因为编号从1开始 所移动步数从2开始枚举)
            for (int k = 2; k <= n + m; k++)
                // 枚举出前路径方案路径1走到第几行
                for (int i1 = 1; i1 <= n; i1++)
                    // 枚举出前路径方案路径2走到第几行
                    for (int i2 = 1; i2 <= n; i2++) {
                        // 由移动步数求出前路径方案两路径处于第几列
                        int j1 = k - i1, j2 = k - i2;
                        // 判断出前路径方案两路径的列有无越界
                        if (j1 < 1 || j1 > m || j2 < 1 || j2 > m)
                            continue;
                        int t = g[i1][j1]; // 记录当前要进入的格子
                        if (i1 != i2)
                            t += g[i2][j2];
                        // 每一种当前路径方案的最大值从两条路径的上一次(k-1)所有移动情况中取最大值
                        // 一: i1,j1从i1,j1-1移动过来(右移) i2,j2从i2,j2-1移动过来(右移)
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2] + t);
                        // 二: i1,j1从i1-1,j1移动过来(右移) i2,j2从i2,j2-1移动过来(下移)
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2] + t);
                        // 三: i1,j1从i1,j1-1移动过来(下移) i2,j2从i2-1,j2移动过来(右移)
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1] + t);
                        // 四: i1,j1从i1-1,j1移动过来(下移) i2,j2从i2-1,j2移动过来(下移)
                        dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1] + t);
                    }
            // 最终两路径均移动到n行 移动步数为n+m
            System.out.println(dp[n + m][n][n]);
        }
    }
}
