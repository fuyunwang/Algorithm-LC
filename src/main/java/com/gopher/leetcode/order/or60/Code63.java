package com.gopher.leetcode.order.or60;

/**
 * @Title Code63
 * @Author fyw
 * @Date 2022/2/9 14:43
 * @Description: 不同路径II
 */
public class Code63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length<1||obstacleGrid[0].length<1){
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] f=new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0){
                f[i][0]=1;
            }else{
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==0){
                f[0][i]=1;
            }else{
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==0){
                    f[i][j]+=f[i-1][j];
                    f[i][j]+=f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }
}
