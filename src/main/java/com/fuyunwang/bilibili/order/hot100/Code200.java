package com.fuyunwang.bilibili.order.hot100;

/**
 * @Title Code200
 * @Author fyw
 * @Date 2022/5/22 21:44
 * @Description:
 */
public class Code200 {
    char[][] g;
    int m,n;
    boolean[][] visited;
    int res=0;
    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,1,0,-1};
    public int numIslands(char[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0)
            return 0;
        m=grid.length;
        n=grid[0].length;
        this.g=grid;
        visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j]=='1'&&!visited[i][j]){
                    res++;
                    dfs(i,j);
                }
            }
        }
        return res;
    }
    void dfs(int x,int y){
        visited[x][y]=true;
        for (int i = 0; i < 4; i++) {
            int a=x+dx[i];
            int b=y+dy[i];
            if (a<0||a>=m||b<0||b>=n||visited[a][b]||g[a][b]!='1')
                continue;
            dfs(a,b);
        }
    }
}
