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
        if (grid[0][0]==1)
            return -1;
        int n=grid.length;
        int[][] result=new int[n][n];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i],-1);
        }
        result[0][0]=1;
        Queue<Integer[]> queue=new LinkedList<>();
        queue.offer(new Integer[]{0,0});
        while (!queue.isEmpty()){
            final Integer[] poll = queue.poll();
            int a=poll[0];
            int b=poll[1];
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i==0&&j==0) continue;
                    int a1=a+i;
                    int b1=b+j;
                    if (a1<0||a1>=n||b1<0||b1>=n||result[a1][b1]!=-1||grid[a1][b1]!=0) continue;
                    result[a1][b1] = result[a][b]+1;
                    queue.offer(new Integer[]{a1,b1});  // queue里面始终存放路径，即当前来到的索引
                }
            }
        }
        return result[n-1][n-1];
    }
}
