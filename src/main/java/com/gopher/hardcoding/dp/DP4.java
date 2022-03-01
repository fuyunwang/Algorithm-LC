package com.gopher.hardcoding.dp;

import java.util.*;
import java.io.*;

/**
 * @Title DP4
 * @Author fyw
 * @Date 2022-02-26 13:22
 * @Description 状态机模型
 */
public class DP4 {
    static class Code1{
        // 如何将只依赖上两层的状态替换只依赖上一层的状态
        // 状态表示： f[i,0]表示不选第i店铺,f[i,1]表示选第i店铺
        // 状态计算： f[i,0]=f[i-1,0]+f[i-1,1]，f[i,1]=f[i-1,0]
        static int N = 100010, INF = 0x3f3f3f3f;
        static int[] w = new int[N];
        static int[][] f = new int[N][2];
        static int n;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T  = Integer.parseInt(br.readLine());
            while(T -- > 0) {
                n = Integer.parseInt(br.readLine());
                String[] s1 = br.readLine().split(" ");
                for(int i = 1;i <= n;i ++) w[i] = Integer.parseInt(s1[i - 1]);
                f[0][0] = 0;
                f[0][1] = -INF;
                for(int i = 1;i <= n;i ++) {
                    f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
                    f[i][1] = f[i - 1][0] + w[i];
                }
                System.out.println(Math.max(f[n][0], f[n][1]));
            }
        }
    }

    static class Code2{
        // 股票交易IV，最多可进行k次交易
        // 状态表示 设f[i][j][0/1]表示只考虑前i天，买卖了j次/j-1次且正在进行第j次交易，当前没有/有股票的最大收益
        // 状态计算 状态机模型包括状态转移与不转移
            // f[i][j][0] = max(f[i - 1][j - 1][1] + w[i], f[i - 1][j][0]);
            // f[i][j][1] = max(f[i - 1][j][0] - w[i], f[i - 1][j][1]);
        static class Code2_1{
            static int N = 100010, M = 110, INF = 0x3f3f3f3f;
            static int n, m;
            static int[] w = new int[N];
            static int[][][] f = new int[N][M][2];
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String[] s1 = br.readLine().split(" ");
                n = Integer.parseInt(s1[0]);    // 数组长度
                m = Integer.parseInt(s1[1]);    // 最多可以完成的交易数量
                String[] s2 = br.readLine().split(" ");
                for(int i = 1;i <= n;i ++) w[i] = Integer.parseInt(s2[i - 1]);
                // dp
                for(int i = 0;i <= n;i ++)
                    for(int j = 0;j <= m;j ++)
                        Arrays.fill(f[i][j], -INF);
                for(int i = 0;i <= n;i ++) f[i][0][0] = 0;
                for(int i = 1;i <= n;i ++)
                    for(int j = 1;j <= m;j ++)
                    {
                        f[i][j][0] = Math.max(f[i - 1][j][1] + w[i], f[i - 1][j][0]);
                        f[i][j][1] = Math.max(f[i - 1][j - 1][0] - w[i], f[i - 1][j][1]);
                    }

                int res = 0;
                for(int i = 1;i <= m;i ++) res = Math.max(res, f[n][i][0]);

                System.out.println(res);
            }
        }

        static class Code2_2{

        }
    }

    static class Code3{
        // 股票交易含有冷冻期V，可以进行无限次交易但交易是有条件的
        // 状态表示。所有从前i个股票中选，当前状态是j的选法
            //f[i][0] f[i][0]表示第i天手里没有票（刚卖出去）对应图中的“没有”
            //f[i][1] f[i][1]表示第i天手里有票（刚买进来） 对应图中的“有”
            //f[i][2] f[i][2]表示第i天是冷冻期之后（手里没有票，但是可以买入票）对应图中的“冷冻期”
        // f[0][2] = f[0][1] = 0，f[0][0] = -INF， 因为在第0个股票一定是无货的，必定从这个位置开始转移才有效
        static int N = 100010, INF = 0x3f3f3f3f;
        static int n;
        static int[] w = new int[N];
        static int[][] f = new int[N][3];
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            String[] s1 = br.readLine().split(" ");
            for(int i = 1;i <= n;i ++) w[i] = Integer.parseInt(s1[i - 1]);

            f[0][2] = f[0][1] = 0; f[0][0] = -INF;
            for(int i = 1;i <= n;i ++)
            {
                f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - w[i]);
                f[i][1] = f[i - 1][0] + w[i];
                f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
            }
            System.out.println(Math.max(f[n][1], f[n][2]));
        }
    }
}
