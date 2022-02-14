package com.gopher.leetcode.order.or900;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title Code994
 * @Author fyw
 * @Date 2022/2/9 14:40
 * @Description: 腐烂的橘子
 * 多源最短路问题、广度优先搜索
 */
public class Code994 {

    public int orangesRotting(int[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0)
            return -1;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==2)
                    queue.offer(new int[]{i,j});
            }
        }
        int[] dx=new int[]{0,0,1,-1};
        int[] dy=new int[]{-1,1,0,0};
        if (!queue.isEmpty()){
            res--;
        }
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                final int[] poll = queue.poll();
                int a=poll[0];
                int b=poll[1];
                for (int d = 0; d < 4; d++) {
                    int x=a+dx[d];
                    int y=b+dy[d];
                    if (x<0||x>=m||y<0||y>=n||grid[x][y]!=1)
                        continue;
                    grid[x][y]=2;
                    queue.offer(new int[]{x,y});
                }
            }
            res++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1)
                    return -1;
            }
        }
        return res;
    }
}
