package com.gopher.leetcode.order.or1000;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title Code1091
 * @Author fyw
 * @Date 2022/1/25 15:53
 * @Description:
 */
public class Code1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
       if (grid==null||grid.length==0||grid[0].length==0){
           return -1;
       }
       int n=grid.length;
       if (grid[0][0]==1||grid[n-1][n-1]==1)
            return -1;

       // 定位二维数组用于保存结果，同时标记是否访问
       int[][] dist=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],-1);
        }
       dist[0][0]=1;

       Queue<int[]> queue=new LinkedList<>();
       queue.offer(new int[]{0,0});

       int[] dx=new int[]{-1,-1,-1,0,1,1,1,0};
       int[] dy=new int[]{-1,0,1,1,1,0,-1,-1};

       while (!queue.isEmpty()){
           int[] poll = queue.poll();
           int x=poll[0];
           int y=poll[1];
           for (int i = 0; i < 8; i++) {
               int a=x+dx[i];
               int b=y+dy[i];
               if (a>=n||a<0||b>=n||b<0||dist[a][b]!=-1||grid[a][b]==1){
                   continue;
               }
               dist[a][b]=dist[x][y]+1;
               queue.offer(new int[]{a,b});
           }
       }
       return dist[n-1][n-1];
    }

}
