package com.gopher.leetcode.order.or400;

/**
 * @Title Code463
 * @Author fyw
 * @Date 2022/2/9 13:50
 * @Description: 岛屿的周长
 * flood fill的简单变形
 */
public class Code463 {
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        int[] dx=new int[]{-1,0,1,0};
        int[] dy=new int[]{0,1,0,-1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    for (int k = 0; k < 4; k++) {
                        int a=i+dx[k];
                        int b=j+dy[k];
                        if (a<0||a>=m||b<0||b>=n||grid[a][b]==0) res++;
                    }
                }
            }
        }
        return res;
    }
}
