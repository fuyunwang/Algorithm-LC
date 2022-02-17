package com.gopher.leetcode.order.or800;

/**
 * @Title Code807
 * @Author fyw
 * @Date 2022/2/9 13:58
 * @Description: 保持城市天际线
 * 本质上是保证每个格子不会超过原始矩阵中格子的每一行和每一列的最大值
 */
public class Code807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        // 记录每一行和每一列的最大值
        int[] row=new int[m];
        int[] col=new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i]=Math.max(row[i],grid[i][j]);
                col[j]=Math.max(col[j],grid[i][j]);
            }
        }
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res+=Math.min(row[i],col[j])-grid[i][j];
            }
        }
        return res;
    }
}
