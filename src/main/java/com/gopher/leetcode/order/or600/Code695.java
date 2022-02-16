package com.gopher.leetcode.order.or600;

/**
 * @Title Code695
 * @Author fyw
 * @Date 2022/2/9 12:38
 * @Description:
 */
public class Code695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int result=0;

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    result=Math.max(dfs(grid,i,j),result);
                }
            }
        }

        return result;
    }
    private int dfs(int[][] grid,int i,int j){
        if (i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!=1){
            return 0;
        }
        grid[i][j]=0;
        return 1+dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
    }
}
