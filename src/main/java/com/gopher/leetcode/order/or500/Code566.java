package com.gopher.leetcode.order.or500;

/**
 * @Title Code566
 * @Author fyw
 * @Date 2022/2/9 14:45
 * @Description: 重塑矩阵
 * reshape，本质是一维数组和二维数组索引的对应
 */
public class Code566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c) return nums;

        int[][] matrix = new int[r][c];
        for (int i = 0; i < row * col; i++)
            matrix[i / c][i % c] = nums[i / col][i % col];

        return matrix;
    }
}
