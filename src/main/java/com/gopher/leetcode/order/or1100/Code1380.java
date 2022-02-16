package com.gopher.leetcode.order.or1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code1380
 * @Author fyw
 * @Date 2022/2/15 15:55
 * @Description:
 * 枚举一定能得到结果
 */
public class Code1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] row=new int[m];
        int[] col=new int[n];
        // 同一行最小，同一列最大
        Arrays.fill(row,100001);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i]=Math.min(row[i],matrix[i][j]);
                col[j]=Math.max(col[j],matrix[i][j]);
            }
        }
        // 幸运数是同时满足行最小列最大
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==row[i]&&matrix[i][j]==col[j]){
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
