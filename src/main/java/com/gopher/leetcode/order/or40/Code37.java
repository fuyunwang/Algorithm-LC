package com.gopher.leetcode.order.or40;

/**
 * @Title Code37
 * @Author fyw
 * @Date 2022/2/9 12:36
 * @Description: 解数独 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * DFS枚举
 */
public class Code37 {
    boolean[][] row;
    boolean[][] col;
    boolean[][][] cell;
    public void solveSudoku(char[][] board) {
        row=new boolean[9][9]; // 标记行中哪一个值被填了，当前行不能再填
        col=new boolean[9][9]; // 标记列中哪一个值被填了，当前列不能再填
        cell=new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){
                    int t=board[i][j]-'1';
                    row[i][t]=col[j][t]=cell[i/3][j/3][t]=true;
                }
            }
        }
        dfs(board,0,0);
    }
    // 填数，遍历通过递归和终止条件共同接管
    boolean dfs(char[][] board,int x,int y){
        if (y==9){
            x++;
            y=0;
            if (x==9) // 正确填完
                return true;
        }
        // 如果当前已经有数直接进行下一轮
        if (board[x][y]!='.')
            return dfs(board,x,y+1);
        // 正式填数
        for (int i = 0; i < 9; i++) {
            if (!row[x][i]&&!col[y][i]&&!cell[x/3][y/3][i]){
                char t= (char) (i+'1');
                board[x][y]=t;
                row[x][i]=col[y][i]=cell[x/3][y/3][i]=true;
                if (dfs(board,x,y+1))
                    return true;
                board[x][y]='.';
                row[x][i]=col[y][i]=cell[x/3][y/3][i]=false;
            }
        }
        return false;
    }
}
