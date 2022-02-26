package com.gopher.hardcoding.dp;


import java.util.Scanner;

/**
 * @Title DP1
 * @Author fyw
 * @Date 2022-02-26 13:20
 * @Description 数字三角形模型、线性DP
 */
public class DP1 {
    // 数字三角形
    static class Code0{
        public static void main (String[] args) {
            int[][] a = new int[510][510];
            int[][] f = new int[510][510];
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int i = 1; i <= n; i ++) {
                for (int j = 1; j <= i; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            for (int i = n; i >= 1; i--) {
                //从最后一排开始走，从下往上。
                for (int j = 1; j <= i; j++) {
                    f[i][j] = Math.max(f[i + 1][j + 1], f[i + 1][j]) + a[i][j];
                }
            }

            System.out.println(f[1][1]);
        }
    }
    // 摘花生
    static class Code1{
        // 状态表示， f[i][j]表示从起点走到[i,j]的所有路径、属性是不同路径上所有花生的最大值
        // 状态计算， 最后一个位置可能由上方下来(f[i-1][j])也可能由左边向右走过来(f[i][j-1])

        static Scanner in = new Scanner(System.in);
        static int N = 110;
        static int w[][] = new int[N][N], f[][] = new int[N][N];

        public static void main(String args[])
        {
            int T = in.nextInt();       // 测试T组
            while (T-- > 0)
            {
                int r = in.nextInt(), c = in.nextInt(); // 行和列
                for (int i = 1; i <= r; i++)
                    for (int j = 1; j <= c; j++)
                        w[i][j] = in.nextInt();         // 每个位置的花生数目
                // dp一定要考虑好顺序
                for (int i = 1; i <= r; i++)
                    for (int j = 1; j <= c; j++)
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + w[i][j];
                System.out.println(f[r][c]);
            }
        }
    }

    // 最低通行费，不能走回头路。和摘花生一样，但是求最小值，所以需要预初始化同时考虑边界
    static class Code2{
        static Scanner in = new Scanner(System.in);
        static int N = 110, INF = 0x3f3f3f3f;
        static int w[][] = new int[N][N], f[][] = new int[N][N];

        public static void main(String args[])
        {
            int n = in.nextInt();
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    w[i][j] = in.nextInt();
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (i == 1 && j == 1) f[i][j] = w[i][j];
                    else
                    {
                        f[i][j] = INF;
                        if (i > 1) f[i][j] = Math.min(f[i][j], f[i - 1][j] + w[i][j]);
                        if (j > 1) f[i][j] = Math.min(f[i][j], f[i][j - 1] + w[i][j]);
                    }
            System.out.println(f[n][n]);
        }
    }
    // 方格取数。从起点走到终点走两次，同一个格子不能重复走，求两次路径之和的最大值
    static class Code3{
        // 状态表示: f[i1 j1,i2 j2]表示从起点走到[i1,j1]、[i2,j2]的路径最大值。
                    // f[k i1, i2]表示从起点走到[i1,k-i1]、[i2,k-i2]的路径最大值，k表示两条路线走到当前格子时的各自横纵坐标之和。
        // 状态计算： 四种情况，分别是第一条线向下、向右和第二条线向下向右的搭配，考虑重复的条件，重复时同一个格子只加一次否则两个格子都算
        static Scanner in = new Scanner(System.in);
        static int N = 15;
        static int w[][] = new int[N][N], f[][][] = new int[N * 2][N][N];

        public static void main(String args[])
        {
            int n = in.nextInt();
            while (true)
            {
                int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
                if (x == 0 && y == 0 && z == 0) break;
                w[x][y] = z;
            }
            for(int k=2; k<=n+n; k++){
                for(int i1=1; i1<=n; i1++){
                    for(int i2=1; i2<=n; i2++){
                        int j1 = k - i1;
                        int j2 = k - i2;
                        if(j1 < 1 || j1 > n || j2 < 1 || j2 > n) continue;  //首先判断是否合理

                        int t = w[i1][j1];
                        if(i1 != i2) t += w[i2][j2];
                        // 枚举四种分类情况
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1-1][i2-1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1-1][i2] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1][i2-1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k-1][i1][i2] + t);
                    }
                }
            }
            System.out.println(f[n + n][n][n]);
        }
    }

}
