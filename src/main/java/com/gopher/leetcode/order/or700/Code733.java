package com.gopher.leetcode.order.or700;

/**
 * @Title Code733
 * @Author fyw
 * @Date 2022/2/9 13:32
 * @Description: 图像渲染
 */
public class Code733 {
    int[][] g;
    int m,n;
    boolean[][] visited;
    int[] dx=new int[]{1,0,-1,0};
    int[] dy=new int[]{0,1,0,-1};
    int newColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        g=image;
        m=g.length;
        n=g[0].length;
        visited=new boolean[m][n];
        this.newColor=newColor;
        dfs(sr,sc,image[sr][sc]);
        return g;
    }
    void dfs(int x,int y,int oldColor){
        if (visited[x][y])
            return;
        visited[x][y]=true;
        g[x][y]=newColor;
        for (int i = 0; i < 4; i++) {
            int a=x+dx[i];
            int b=y+dy[i];
            if (a>=m||a<0||b>=n||b<0||g[a][b]!=oldColor)
                continue;
            dfs(a,b,oldColor);
        }
    }
}
