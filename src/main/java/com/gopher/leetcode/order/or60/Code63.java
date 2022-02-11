package com.gopher.leetcode.order.or60;

/**
 * @Title Code63
 * @Author fyw
 * @Date 2022/2/9 14:43
 * @Description: 不同路径II
 */
public class Code63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x=obstacleGrid.length;
        if (x==0)
            return 0;
        int y=obstacleGrid[0].length;
        int[][] f=new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (obstacleGrid[i][j]==0){
                    if (i==0&&j==0)
                        f[i][j]=1;
                    if (i!=0)
                        f[i][j]+=f[i-1][j];
                    if (j!=0)
                        f[i][j]+=f[i][j-1];
                }
            }
        }
        return f[x-1][y-1];
    }

}
