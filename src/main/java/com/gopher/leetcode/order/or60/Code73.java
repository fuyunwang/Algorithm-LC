package com.gopher.leetcode.order.or60;

/**
 * @Title Code73
 * @Author fyw
 * @Date 2022/2/9 13:47
 * @Description: 矩阵置0
 */
public class Code73 {
    public void setZeroes(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return;
        boolean r0=false,c0=false;
        int m=matrix.length,n=matrix[0].length;
        // 首先记录第一行和第一列是否需要完整置0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0]==0)
                c0=true;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i]==0)
                r0=true;
        }
        // 考虑除了第一行和第一列之外的元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {// 如果记录过这一行应该为0，那么元素直接置0
                    matrix[i][j] = 0;
                }
            }
        }
        // 把0行和0列的状态正确化
        if (r0){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }
        if (c0){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
