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
            boolean[] visited=new boolean[9];
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
                            if (board[i+k][j+l]!='.'){
                                int cur=board[i+k][j+l]-'1';
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

    }
}
