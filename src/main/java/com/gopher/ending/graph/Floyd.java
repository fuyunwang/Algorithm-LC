package com.gopher.ending.graph;
import java.io.*;
import java.util.*;

/**
 * @Title Floyd
 * @Author fyw
 * @Date 2022-03-17 10:16
 * @Description
 */
public class Floyd {
    static class CodeWing1{
        static int n;
        static int m;
        static int q;
        static int N = 210;
        static int INF = 0x3f3f3f3f;
        static int[][] d = new int[N][N];
        public static void floyd()
        {
            for(int k = 1;k <= n;k++)
                for(int i = 1;i <= n;i++)
                    for(int j = 1;j <= n;j++)
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
        }
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = reader.readLine().split(" ");
            n = Integer.parseInt(str1[0]);
            m = Integer.parseInt(str1[1]);
            q = Integer.parseInt(str1[2]);
            for(int i = 1;i <= n;i++)
            {
                for(int j = 1;j <= n;j++)
                {
                    if(i == j) d[i][j] = 0;
                    else d[i][j] = INF;
                }
            }
            while(m -- > 0)
            {
                String[] str2 = reader.readLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                int c = Integer.parseInt(str2[2]);
                d[a][b] = Math.min(d[a][b], c);//若有重边选择短的边
            }
            floyd();
            while(q -- > 0)
            {
                String[] str3 = reader.readLine().split(" ");
                int a = Integer.parseInt(str3[0]);
                int b = Integer.parseInt(str3[1]);
                int t = d[a][b];
                if(t > INF / 2) System.out.println("impossible");
                else System.out.println(t);
            }
        }
    }
}
