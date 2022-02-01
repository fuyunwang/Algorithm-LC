package com.gopher.leetcode;

/**
 * @Title Code200
 * @Author fyw
 * @Date 2022/2/1 19:44
 * @Description:
 */
public class Code200 {
    public int numIslands(char[][] grid) {
        if (grid==null||grid.length==0)
            return 0;
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    res++;
                    infect(grid,i,j);
                }
            }
        }
        return res;
    }
    void infect(char[][] grid, int i, int j){
        if (i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        infect(grid,i-1,j);
        infect(grid,i+1,j);
        infect(grid,i,j-1);
        infect(grid,i,j+1);
    }
}
