package com.gopher.leetcode;

import java.util.Arrays;

/**
 * @Title Code36
 * @Author fyw
 * @Date 2022/1/24 18:20
 * @Description: 有效的数独，模拟题
 */
public class Code36 {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        boolean[] st = new boolean[10];

        //判断行
        for(int i = 0;i < n;i ++)
        {
            Arrays.fill(st,false);
            for(int j = 0;j < n;j ++)
            {
                if(board[i][j] != '.')
                {
                    int t = board[i][j] - '0';
                    if(st[t]) return false;
                    st[t] = true;
                }
            }
        }
        //判断列
        for(int i = 0;i < n;i ++)
        {
            Arrays.fill(st,false);
            for(int j = 0;j < n;j ++)
            {
                if(board[j][i] != '.')
                {
                    int t = board[j][i] - '0';
                    if(st[t]) return false;
                    st[t] = true;
                }
            }
        }
        //判断九宫格
        for(int i = 0;i < n;i += 3)
        {
            for(int j = 0;j < n;j += 3)
            {
                Arrays.fill(st,false);
                for(int u = 0;u < 3;u ++)
                {
                    for(int v = 0;v < 3;v ++)
                    {
                        if(board[i + u][j + v] != '.')
                        {
                            int t = board[i + u][j + v] - '0';
                            if(st[t]) return false;
                            st[t] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

}
