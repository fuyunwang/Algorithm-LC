package com.gopher.leetcode.types;

/**
 * @Title DFS1
 * @Author fyw
 * @Date 2022-03-03 20:46
 * @Description floodfill
 */
public class DFS1 {
    static class Code1905{
        int m,n;
        boolean flag=false;
        int[] dx=new int[]{-1,0,1,0};
        int[] dy=new int[]{0,1,0,-1};
        boolean[][] visited;
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            m=grid1.length;
            n=grid1[0].length;
            visited=new boolean[m][n];
            int res=0;
            // 针对岛屿2进行陆地遍历
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    flag=true;
                    if (grid2[i][j]==1&&!visited[i][j]){
                        dfs(grid1,grid2,i,j);
                        if(flag){
                            res++;
                        }
                    }
                }
            }
            return res;
        }
        void dfs(int[][] grid1,int[][] grid2,int x,int y){
            // 能进入这里的都是岛屿2的陆地
            if (grid1[x][y]!=1){
                // 一旦岛屿1不是陆地，那本次整个dfs都已经得到结果，所以不能采用return false的递归
                flag=false;
                return;
            }
            visited[x][y]=true;
            for (int i = 0; i < 4; i++) {
                int a=x+dx[i];
                int b=y+dy[i];
                if (a>=m||a<0||b>=n||b<0||grid2[a][b]!=1||visited[a][b])
                    continue;
                dfs(grid1,grid2,a,b);
            }
        }
    }

    static class Code1034{

    }

    static class Code695{

    }
}
