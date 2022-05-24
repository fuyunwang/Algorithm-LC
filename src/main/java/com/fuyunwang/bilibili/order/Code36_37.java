package com.fuyunwang.bilibili.order;

import java.util.Arrays;

/**
 * @Title Code36_37
 * @Author fyw
 * @Date 2022/5/21 17:21
 * @Description: 数独
 */
public class Code36_37 {
    static class Code36{
        public boolean isValidSudoku(char[][] board) {
            boolean[] visited=new boolean[9];   // 记录当前有哪些元素已经出现过，避免重复出现，如果重复出现则不是一个合法方案
            for (int i = 0; i < 9; i++) {
                Arrays.fill(visited,false);
                for (int j = 0; j < 9; j++) {
                    if (board[i][j]!='.'){
                        int cur=board[i][j]-'1';
                        if (visited[cur])
                            return false;
                        visited[cur]=true;
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                Arrays.fill(visited,false);
                for (int j = 0; j < 9; j++) {
                    if (board[j][i]!='.'){
                        int cur=board[j][i]-'1';
                        if (visited[cur])
                            return false;
                        visited[cur]=true;
                    }
                }
            }
            for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    Arrays.fill(visited,false);
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (board[k+i][l+j]!='.'){
                                int cur=board[k+i][l+j]-'1';
                                if (visited[cur])
                                    return false;
                                visited[cur]=true;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
    static class Code37{
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][][] cell=new boolean[3][3][9];
        char[][] g;
        public void solveSudoku(char[][] board) {
            if (board==null||board.length==0||board[0].length==0)
                return;
            g=board;
            // 初始化
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j]!='.'){
                        int cur=board[i][j]-'1';
                        row[i][cur]=col[j][cur]=cell[i/3][j/3][cur]=true;
                    }
                }
            }
            dfs(0,0);
        }
        boolean dfs(int x,int y){
            if (y==9){
                x++;
                y=0;
            }
            if (x==9){
                return true;
            }
            if (g[x][y]!='.')
                return dfs(x,y+1);
            for (int i = 0; i < 9; i++) {
                if (!row[x][i]&&!col[y][i]&&!cell[x/3][y/3][i]){
                    row[x][i]=col[y][i]=cell[x/3][y/3][i]=true;
                    char c= (char) (i+'1');
                    g[x][y]=c;
                    if (dfs(x,y+1))
                        return true;
                    g[x][y]='.';
                    row[x][i]=col[y][i]=cell[x/3][y/3][i]=false;
                }
            }
            return false;
        }
    }
}
