package com.gopher.leetcode.order.or60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code54
 * @Author fyw
 * @Date 2022/1/29 19:40
 * @Description: 螺旋矩阵 蛇形矩阵
 */
public class Code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix.length;
        if (m==0)
            return res;
        int n=matrix[0].length;
        int[] dx=new int[]{0,1,0,-1};
        int[] dy=new int[]{1,0,-1,0};
        boolean[][] valid=new boolean[m][n];
        for (int i = 0; i < valid.length; i++) {
            Arrays.fill(valid[i],false);
        }
        for (int i = 0,a=0,b=0,d=0; i < m*n; i++) {
            res.add(matrix[a][b]);
            valid[a][b]=true;

            // 记录即将访问的点
            int x=a+dx[d],y=b+dy[d];
            if (x>=m||x<0||y>=n||y<0||valid[x][y]){
                // 维护循环方向不变
                d = (d+1)%4;
                x=a+dx[d];
                y=b+dy[d];
            }

            a=x;
            b=y;
        }
        return res;
    }
}
