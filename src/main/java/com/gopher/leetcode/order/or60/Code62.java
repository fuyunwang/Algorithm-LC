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
        int[][] f=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0&&j==0)
                    f[i][j]=1;
                if (i!=0){
                    f[i][j]+=f[i-1][j];
                }
                if (j!=0){
                    f[i][j]+=f[i][j-1];
                }
            }
        }
        return f[n-1][m-1];
    }
}
