package com.gopher.ending.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title MemoSearch
 * @Author fyw
 * @Date 2022-03-14 15:40
 * @Description
 */
public class MemoSearch {
    static class CodeWing1{
        // 滑雪，可以向四个方向滑且终止条件是大于当前位置
        /**
         * 记忆化搜索
         * f[i,j]表示从当前(i,j)出发可以走到的最大值
         * 枚举四个方向来更新状态
         */
        static int N=310;
        static int n,m;
        static int[][] f=new int[N][N];     // 记录状态
        static int[][] g=new int[N][N];
        static int[] dx=new int[]{0,-1,0,1};
        static int[] dy=new int[]{-1,0,1,0};
        static int dfs(int x,int y){   // 得到从当前状态枚举的最大值
            if (f[x][y]!=-1){
                return f[x][y];
            }
            // 初始值是1
            f[x][y]=1;
            for (int i = 0; i < 4; i++) {
                int a=x+dx[i];
                int b=y+dy[i];
                if (a<0||a>=n||b<0||b>=m)
                    continue;
                if (g[a][b]<g[x][y])   // 更新状态
                    f[x][y]=Math.max(f[x][y],dfs(a,b)+1);
            }
            return f[x][y];
        }
        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            n=scanner.nextInt();
            m=scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    g[i][j]=scanner.nextInt();
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(f[i],-1);
            }
            int res=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res=Math.max(res,dfs(i,j));
                }
            }
            System.out.println(res);
        }
    }
}
