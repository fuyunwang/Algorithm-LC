package com.gopher.leetcode.order.or60;

import java.util.Arrays;

/**
 * @Title Code64
 * @Author fyw
 * @Date 2022/2/9 12:30
 * @Description: 最小路径和
 * 基于Code62 Code63求所有路径和的最小值
 */
public class Code64 {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        if (n==0)
            return 0;
        int m=grid[0].length;
        int[][] f=new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0&&j==0)
                    f[i][j]=grid[i][j];
                if (i!=0)
                    f[i][j]=Math.min(f[i][j],f[i-1][j]+grid[i][j]);
                if (j!=0)
                    f[i][j]=Math.min(f[i][j],f[i][j-1]+grid[i][j]);
            }
        }
        return f[n-1][m-1];
    }
}
