package com.gopher.leetcode.order.or1800;

/**
 * @Title Code1905
 * @Author fyw
 * @Date 2022/2/16 21:47
 * @Description:
 */
public class Code1905 {
    int m,n;
    boolean flag=false;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m=grid1.length;
        n=grid1[0].length;
        int res=0;

        // 针对岛屿2进行陆地遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j]==1){
                    flag=true;
                    dfs(grid1,grid2,i,j);
                    if (flag){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    void dfs(int[][] grid1,int[][] grid2,int x,int y){
        if (x>=m||x<0||y>=n||y<0||grid2[x][y]!=1){
            return;
        }
        // 能进入这里的都是岛屿2的陆地
        if (grid1[x][y]!=1){
            // 一旦岛屿1不是陆地，那本次整个dfs都已经得到结果
            flag=false;
            return;
        }
        grid2[x][y]=2;
        dfs(grid1,grid2,x+1,y);
        dfs(grid1,grid2,x-1,y);
        dfs(grid1,grid2,x,y+1);
        dfs(grid1,grid2,x,y-1);
    }
}
