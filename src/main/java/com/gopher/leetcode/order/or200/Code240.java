package com.gopher.leetcode.order.or200;

/**
 * @Title Code240
 * @Author fyw
 * @Date 2022/2/8 22:05
 * @Description: 搜索二维矩阵 II
 */
public class Code240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m-1;
        int col = 0;
        for(;row>=0&&col<n;){
            if(target<matrix[row][col]){
                row--;
            }else if(target>matrix[row][col]){
                col++;
            }else{
                return true;
            }
        }
        return false;
    }
}
