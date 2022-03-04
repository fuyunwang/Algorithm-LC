package com.gopher.leetcode.types.graph;

import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022-03-03 9:55
 * @Description
 */
public class BFS {
    static class Code1091{
        // 二进制矩阵中的最短路径，迷宫问题
        public static int shortestPathBinaryMatrix(int[][] grid) {
            if (grid==null||grid.length==0||grid[0].length==0)
                return -1;
            int n=grid.length;
            if (grid[0][0]!=0||grid[n-1][n-1]!=0)
                return -1;

            int[][] step=new int[n][n];
            for (int i = 0; i < step.length; i++) {
                Arrays.fill(step[i],-1);
            }
            step[0][0]=1;
            Queue<int[]> queue=new LinkedList<>();
            queue.offer(new int[]{0,0});
            int[] dx=new int[]{-1,0,1,-1,1,-1,0,1};
            int[] dy=new int[]{-1,-1,-1,0,0,1,1,1};

            while (!queue.isEmpty()){
                int[] poll = queue.poll();
                int x=poll[0];
                int y=poll[1];
                if (x==n-1&&y==n-1)
                    return step[x][y];
                for (int d=0;d<8;d++){
                    int a=x+dx[d];
                    int b=y+dy[d];
                    if (a>=n||a<0||b>=n||b<0||grid[a][b]!=0||step[a][b]!=-1)
                        continue;
                    queue.offer(new int[]{a,b});
                    step[a][b]=step[x][y]+1;
                }
            }
            return -1;
        }

        static class Pair{
            int x;
            int y;
            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this==o)
                    return true;
                if (o==null)
                    return false;
                if (o instanceof Pair){
                    Pair oPair= (Pair) o;
                    return oPair.x==this.x&&oPair.y==this.y;
                }
                return false;
            }

            @Override
            public int hashCode() {
                int result=17;
                result=31*result+x;
                result=31*result+y;
                return result;
            }
        }

        public static void main(String[] args) {
            int[][] g=new int[][]{{0,0,0},{1,1,0},{1,1,0}};
            shortestPathBinaryMatrix(g);
        }
    }
}
