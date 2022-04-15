package com.gopher.leetcode.order.or60;

/**
 * @Title Code62
 * @Author fyw
 * @Date 2022/2/9 12:40
 * @Description: 不同路径
 * f[i][j]定义为从【0,0】走到【i,j】的路径数
 */
public class Code62 {
    public int uniquePaths(int m, int n) {
        int[][] f=new int[m][n];
        for(int i=0;i<m;i++){
            f[i][0]=1;
        }
        for(int i=0;i<n;i++){
            f[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j]+=f[i-1][j];
                f[i][j]+=f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
}
