package com.gopher.leetcode;

/**
 * @Title Code74
 * @Author fyw
 * @Date 2022/2/2 10:08
 * @Description: 搜索二维矩阵
 */
public class Code74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int starty=0, startx=m-1;
        for (;startx>=0&&starty<n;){
            if (matrix[startx][starty]>target){
                startx--;
            }else if (matrix[startx][starty]<target){
                starty++;
            }else{
                return true;
            }
        }
        return false;
    }
}
