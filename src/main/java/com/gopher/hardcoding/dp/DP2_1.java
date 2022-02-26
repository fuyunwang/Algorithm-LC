package com.gopher.hardcoding.dp;

import java.util.Scanner;

/**
 * @Title DP2
 * @Author fyw
 * @Date 2022-02-26 13:21
 * @Description 最长上升子序列模型1
 */
public class DP2_1 {
    //LIS
    static class Code0{
        // 状态表示：f[i]表示以a[i]结尾的严格单调上升子序列集合
        // 状态计算：f[i]集合进行划分，（考虑最后一个不同的点，由于这里最后一个点都相同，所以考虑倒数第二个点）
        static Scanner in = new Scanner(System.in);
        static int N = 1010;
        static int a[] = new int[N], f[] = new int[N];

        public static void main(String args[]) {
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) a[i] = in.nextInt();
            // dp解决
            int max = 0;
            for (int i = 1; i <= n; i++) {
                f[i] = 1;
                for (int j = 1; j < i; j++) {
                    if (a[j] < a[i])
                        f[i] = Math.max(f[i], f[j] + 1);
                }
                max = Math.max(max, f[i]);
            }
            System.out.println(max);
        }
    }
    // 怪盗基德的滑翔翼，跳的时候只能单调递减，所以考虑每个点的两个方向上的最长递增子序列
    static class Code1{
        static Scanner in = new Scanner(System.in);
        static int N = 110;
        static int w[] = new int[N], f[] = new int[N];

        public static void main(String args[]) {
            int K = in.nextInt();
            while (K-- > 0) {
                int n = in.nextInt();
                for (int i = 1; i <= n; i++) w[i] = in.nextInt();
                int max = 0;
                for (int i = 1; i <= n; i++) {
                    f[i] = 1;
                    for (int j = 1; j < i; j++)
                        if (w[j] > w[i])
                            f[i] = Math.max(f[i], f[j] + 1);
                    max = Math.max(max, f[i]);
                }
                for (int i = 0; i < N; i++) f[i] = 0;
                for (int i = n; i > 0; i--) {
                    f[i] = 1;
                    for (int j = n; j > i; j--)
                        if (w[j] > w[i])
                            f[i] = Math.max(f[i], f[j] + 1);
                    max = Math.max(max, f[i]);
                }
                System.out.println(max);
            }
        }
    }
    // 登山，严格单调上升后严格单调下降的DP，考虑不同的峰值时的最优解
    static class Code2{
        static Scanner in = new Scanner(System.in);
        static int N = 1010;
        static int h[] = new int[N], f[] = new int[N], g[] = new int[N];

        public static void main(String args[])
        {
            int n = in.nextInt();
            for (int i = 1; i <= n; i++) h[i] = in.nextInt();
            int res = 0;
            for (int i = 1; i <= n; i++)
            {
                f[i] = 1;
                for (int j = 1; j < i; j++)
                    if (h[j] < h[i])
                        f[i] = Math.max(f[i], f[j] + 1);
                res = Math.max(res, f[i]);
            }
            for (int i = n; i > 0; i--)
            {
                g[i] = 1;
                for (int j = n; j > i; j--)
                    if (h[j] < h[i])
                        g[i] = Math.max(g[i], g[j] + 1);
                res = Math.max(res, f[i] + g[i] - 1);
            }
            System.out.println(res);
        }
    }

    static class Code3{
        
    }

}
