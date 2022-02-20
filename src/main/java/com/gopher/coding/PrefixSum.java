package com.gopher.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title PrefixSum
 * @Author fyw
 * @Date 2022/2/20 16:47
 * @Description:
 */
public class PrefixSum {
    static class Code1{
        public static void main(String[] args) throws IOException {
            // 初始化
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str = reader.readLine().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);
            int n = Integer.parseInt(str[2]);
            int[][] matrix = new int[row][col];
            for(int i = 0; i < row; i++){
                String[] str1 = reader.readLine().split(" ");
                for(int j = 0; j < col; j++){
                    matrix[i][j] = Integer.parseInt(str1[j]);
                }
            }
            // 计算前缀和
            int[][] sum = new int[row + 1][col + 1];
            for(int i = 1; i < row + 1; i++){
                for(int j = 1; j < col + 1; j++){
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
            for(int i = 0; i < n; i++){
                String[] str2 = reader.readLine().split(" ");
                int row1 = Integer.parseInt(str2[0]);
                int col1 = Integer.parseInt(str2[1]);
                int row2 = Integer.parseInt(str2[2]);
                int col2 = Integer.parseInt(str2[3]);

                System.out.println(sum[row2][col2] - sum[row1 -1][col2] -
                        sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1]);
            }
        }
    }
}
