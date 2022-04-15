package com.gopher.leetcode.order.or200;

/**
 * @Title Code221
 * @Author fyw
 * @Date 2022/2/9 13:49
 * @Description: 最大正方形
 * dp
 */
public class Code221 {
    // f[i+1,j+1]表示以[i,j]为右下角点的最大正方形边长
    // f[i+1,j+1]表示以[i,j]分别向上、左、左上角看，直到遇到限制的0，形成最大的可能正方形
    public int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length<1||matrix[0].length<1)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] f=new int[m+1][n+1];
        int res=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1]=='1'){
                    f[i][j]=Math.min(f[i-1][j],Math.min(f[i][j-1],f[i-1][j-1]))+1;
                    res=Math.max(res,f[i][j]);
                }
            }
        }
        return res*res;
    }
}
