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
    static class CodeWing1{
        // 数字三角形
    }
    static class CodeWing2{
        // 摘花生
        /**
         * f[i,j]表示从[1,1]走到[i,j]的所有路线中能取到花生数的最大值。
         * 状态计算考虑最后一个位置可以从[i-1,j]或者[i,j-1]转移过来
         */
        static int N=110;
        static int[][] f=new int[N][N];
        public static void main(String[] args) throws IOException{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(reader.readLine().trim());
            while(T-->0){
                // 首先读入行和列
                String[] str=reader.readLine().trim().split(" ");
                int r=Integer.parseInt(str[0]);
                int c=Integer.parseInt(str[1]);
                for (int i = 1; i <= r; i++) {
                    str = reader.readLine().trim().split(" ");
                    for (int j = 1; j <= c; j++) {
                        f[i][j]=Integer.parseInt(str[j-1]);
                    }
                }
                // 进行状态转移计算
                for (int i = 1; i <= r; i++) {
                    for (int j = 1; j <= c; j++) {
                        f[i][j]=Math.max(f[i-1][j],f[i][j-1])+f[i][j];
                    }
                }
                System.out.println(f[r][c]);
            }
        }
    }
    static class CodeWing3{
        // 最低通行费，多了一个限制必须在2n-1内走到(其实本质还是不能走回头路)，求最小值
        // 本质还是求矩阵中一条路线权值之和的最小值
        static int N=110;
        static int[][] f=new int[N][N];
        public static void main(String[] args) throws IOException{
//            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            int[][] g=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
//                final String[] split = reader.readLine().trim().split(" ");
                for (int j =1; j<= n; j++) {
                    g[i][j]=scanner.nextInt();
                }
            }
            // 进行状态转移计算，注意求最小值需要特判
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i==1&&j==1) f[i][j]=g[i][j];
                    else{
                        f[i][j]=Integer.MAX_VALUE;
                        if (i>1)
                            f[i][j]=Math.min(f[i][j],f[i-1][j]+g[i][j]);
                        if (j>1){
                            f[i][j]=Math.min(f[i][j],f[i][j-1]+g[i][j]);
                        }
                    }
                }
            }
            System.out.println(f[n][n]);
        }
    }
    static class CodeWing4{
        // 方格取数
        // 还是从左上角走到右下角，不过是走两次，而且走过一次的格子不能再走
    }
    static class CodeWing5{
       // 传纸条
    }
}
