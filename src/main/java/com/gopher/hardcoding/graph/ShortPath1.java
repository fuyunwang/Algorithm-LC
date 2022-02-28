package com.gopher.hardcoding.graph;

import java.util.*;
import java.io.*;

/**
 * @Title ShortPath
 * @Author fyw
 * @Date 2022-02-28 14:37
 * @Description 单源最短路
 */
public class ShortPath1 {
    static class Code1{
        // 信使，关键路径的思想
        static int N = 110, INF = 0x3f3f3f3f;
        static int[][] d = new int[N][N];

        public static void main(String[] args) throws IOException{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String[] arr = in.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);

            // 将距离初始化为正无穷，防止出现重边
            for(int i=1; i<=n; i++) Arrays.fill(d[i], INF);
            // 这里不需要将d[i][i] = 0，因为题目中并没有需要求求d[i][i]
            // for(int i=1; i<=n; i++) d[i][i] = 0;

            while(m -- > 0){
                String[] cur = in.readLine().split(" ");
                int a = Integer.parseInt(cur[0]);
                int b = Integer.parseInt(cur[1]);
                int c = Integer.parseInt(cur[2]);

                d[a][b] = d[b][a] = Math.min(d[a][b], c);
            }

            // Floyd算法
            for(int k=1; k<=n; k++){
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=n; j++){
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }

            // 找出所有最短路径中最长的距离
            int res = 0;
            for(int i=2; i<=n; i++){
                if(d[1][i] == INF){
                    res = -1;
                    break;
                }
                res = Math.max(res, d[1][i]);
            }

            System.out.println(res);
        }

    }
}
