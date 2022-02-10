package com.gopher.leetcode.order.or50;

/**
 * @Title Code48
 * @Author fyw
 * @Date 2022/2/9 12:39
 * @Description: 旋转图像
 * 类似螺旋数组
 */
public class Code48 {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        for (int i = 0; i < len/2; i++) {
            int start=i;
            int end=len-1-i;
            for (int j = 0; j < end-start; j++) {
                int temp=matrix[start][start+j];
                matrix[start][start+j]=matrix[end-j][start];
                matrix[end-j][start]=matrix[end][end-j];
                matrix[end][end-j]=matrix[start+j][end];
                matrix[start+j][end]=temp;
            }
        }
    }
}
