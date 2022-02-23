package com.gopher.leetcode.order.or120;

/**
 * @Title Code174
 * @Author fyw
 * @Date 2022/2/9 14:02
 * @Description: 地下城游戏
 * dp类似Code62、Code63
 */
public class Code174 {
    // 状态计算，根据最后一步走的方式划分集合
        // 可能向右走 (i,j) -> (i,j+1)
        // 可能向下走 (i,j) -> (i+1,j)
    public int calculateMinimumHP(int[][] w) {
        int n=w.length;
        int m=w[0].length;
        // 倒推
        int[][] f = new int[n + 10][m + 10];
        for(int i = n - 1;i >= 0;i --)
            for(int j = m - 1;j >= 0;j --)
            {
                f[i][j] = 0x3f3f3f3f;
                if(i == n - 1 && j == m - 1) f[i][j] = Math.max(1, 1 - w[i][j]);
                else
                {
                    if(i + 1 < n) f[i][j] = f[i + 1][j] - w[i][j];
                    if(j + 1 < m) f[i][j] = Math.min(f[i][j], f[i][j + 1] - w[i][j]);
                    f[i][j] = Math.max(1, f[i][j]);
                }
            }
        return f[0][0];

    }
}
