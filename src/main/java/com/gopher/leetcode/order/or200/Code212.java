package com.gopher.leetcode.order.or200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Title Code212
 * @Author fyw
 * @Date 2022/2/18 14:50
 * @Description: 单词搜索 II
 */
public class Code212 {
    int m,n;
    List<String> res=new ArrayList<>();
    int[] dx=new int[]{0,1,0,-1};
    int[] dy=new int[]{-1,0,1,0};
    HashSet<String> set=new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        m=board.length;
        n=board[0].length;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[j][k]==words[i].charAt(0)){
                        dfs(board,words[i],0,j,k);
                    }
                }
            }
        }
        for (String s:set){
            res.add(s);
        }
        return res;
    }
    void dfs(char[][] board,String word,int u,int x,int y){
        if (board[x][y]!=word.charAt(u))
            return;
        if (u==word.length()-1){
            set.add(word);
            return;
        }
        char temp=board[x][y];
        board[x][y]='*';    // 避免重复使用的策略
        for (int i = 0; i < 4; i++) {
            int a=x+dx[i];
            int b=y+dy[i];
            if (a<0||a>=m||b<0||b>=n||board[a][b]=='*') continue;
            dfs(board,word,u+1,a,b);
        }
        board[x][y]=temp;
    }
}
