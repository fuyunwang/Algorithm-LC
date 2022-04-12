package com.gopher.leetcode.order.or1000;

/**
 * @Title Code1034
 * @Author fyw
 * @Date 2022/2/7 13:08
 * @Description:
 */
public class Code1034 {
    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,1,0,-1};
    boolean[][] visited;
    int m,n;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m=grid.length;
        n=grid[0].length;
        visited=new boolean[m][n];
        int oldColor=grid[row][col];
        dfs(grid,row,col,color,oldColor);
        return grid;
    }
    void dfs(int[][] grid,int r,int c,int color,int oldColor){
        if (r<0||r>=m||c<0||c>=n||visited[r][c]||grid[r][c]!=oldColor)
            return;
        if (check(grid,r,c,oldColor))
            grid[r][c]=color;
        visited[r][c]=true;
        for (int i = 0; i < 4; i++) {
            int newR=r+dx[i];
            int newC=c+dy[i];
            dfs(grid,newR,newC,color,oldColor);
        }
    }
    public boolean check(int[][] g, int row, int col, int oldC) {
        if (row == 0 || row == m - 1 || col == 0 || col == n - 1) return true;
        for (int i = 0; i < 4; i++) {
            if (!visited[row + dx[i]][col + dy[i]] && g[row + dx[i]][col + dy[i]] != oldC) return true;
        }
        return false;
    }

    class Code{
        boolean[][] visited;
        int m,n;
        int[][] g;
        int oldColor;
        int[] dx=new int[]{-1,0,1,0};
        int[] dy=new int[]{0,1,0,-1};
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            m=grid.length;
            n=grid[0].length;
            g=grid;
            visited=new boolean[m][n];
            oldColor=g[row][col];
            dfs(row,col);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]){
                        // 此时属于连通块内容
                        for (int d = 0; d < 4; d++) {
                            int a=i+dx[d];
                            int b=j+dy[d];
                            if (a<0||a>=m||b<0||b>=n)
                                continue;
                            if ((a==0||a==m-1||b==0|b==n-1)&&visited[a][b]){
                                g[a][b]=color;
                            }else if (!visited[a][b]){
                                g[i][j]=color;
                            }
                        }
                    }
                }
            }
            return g;
        }

        void dfs(int x,int y){
            if (x<0||x>=m||y<0||y>=n||g[x][y]!=oldColor||visited[x][y]){
                return;
            }
            visited[x][y]=true;
            for (int i = 0; i < 4; i++) {
                int a=x+dx[i];
                int b=y+dy[i];
                dfs(a,b);
            }
        }
    }
}


