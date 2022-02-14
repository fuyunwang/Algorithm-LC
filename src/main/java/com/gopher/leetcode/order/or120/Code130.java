package com.gopher.leetcode.order.or120;

/**
 * @Title Code130
 * @Author fyw
 * @Date 2022/2/9 14:47
 * @Description: 被围绕的区域
 * flood fill算法
 * 逆向思维，对边界的‘O’进行替换、Code200岛屿数量、Code749隔离病毒
 */
public class Code130 {
    char[][] grid;
    public void solve(char[][] board) {
        if (board==null||board.length==0||board[0].length==0)
            return;
        this.grid=board;
        // 枚举四个边界
        for (int i = 0; i < grid.length; i++) {
            infect(i,0);
        }
        for (int i = 0; i < grid.length; i++) {
            infect(i,grid[0].length-1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            infect(0,i);
        }
        for (int i = 0; i < grid[0].length; i++) {
            infect(grid.length-1,i);
        }
        // 进行重新反向染色，得到结果
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='O')
                    grid[i][j]='X';
                if (grid[i][j]=='A')
                    grid[i][j]='O';
            }
        }
    }
    public void infect(int x,int y){    // 传入坐标，对边界上的'O'进行染色
        if (x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]!='O')
            return;
        grid[x][y]='A';
        infect(x+1,y);
        infect(x-1,y);
        infect(x,y+1);
        infect(x,y-1);
    }

}
