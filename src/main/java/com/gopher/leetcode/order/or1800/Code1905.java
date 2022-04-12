package com.gopher.leetcode.order.or1800;

/**
 * @Title Code1905
 * @Author fyw
 * @Date 2022/2/16 21:47
 * @Description:
 */
public class Code1905 {
    int m,n;
    boolean[][] visited;
    int[][] g1,g2;
    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,-1,0,1};
    boolean flag;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m=grid1.length;
        n=grid1[0].length;
        g1=grid1;
        g2=grid2;
        visited=new boolean[m][n];
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 对g2所有的连通块遍历
                if (g2[i][j]==1&&!visited[i][j]){
                    flag=true;
                    dfs(i,j);
                    if (flag){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    void dfs(int row,int col){
        if (row<0||row>=m||col<0||col>=n||g2[row][col]!=1||visited[row][col]){
            return;
        }
        if (g1[row][col]!=1){
            flag=false;
            return;
        }
        visited[row][col]=true;
        for (int d = 0; d < 4; d++) {
            int a=row+dx[d];
            int b=col+dy[d];
            dfs(a,b);
        }
    }
}
