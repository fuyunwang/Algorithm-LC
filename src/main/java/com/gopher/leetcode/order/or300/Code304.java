package com.gopher.leetcode.order.or300;

/**
 * @Title Code304
 * @Author fyw
 * @Date 2022/2/16 19:59
 * @Description:
 * 二维前缀和
 */
public class Code304 {
    class NumMatrix {
        int[][] s;
        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            if(n != 0){
                int m = matrix[0].length;
                if(m!=0){
                    s = new int[n+1][m+1];
                    for(int i = 1;i<n+1;i++){
                        for(int j = 1;j<m+1;j++){
                            s[i][j] = s[i-1][j]+s[i][j-1]-s[i-1][j-1] + matrix[i-1][j-1];
                        }
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;
            col1++;
            row2++;
            col2++;
            return s[row2][col2] -s[row2][col1-1] - s[row1-1][col2] + s[row1-1][col1-1];
        }

    }
}
