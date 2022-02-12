package com.gopher.leetcode.order.or60;

/**
 * @Title Code79
 * @Author fyw
 * @Date 2022/2/9 13:55
 * @Description: 单词搜索
 * 高频题目，dfs，回溯
 */
public class Code79 {
    int n;
    int m;
    // 递归的时候需要四个方向
    int[] dx=new int[]{0,1,0,-1};
    int[] dy=new int[]{1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        n=board.length;
        m=board[0].length;
        // 从每一个可能的坐标起点去深度优先搜索
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if (board[i][j]==word.charAt(0)){
                   // 0表示从头开始遍历字符直到满足word
                   if (dfs(board,word,0,i,j)){
                       return true;
                   }
               }
            }
        }
        return false;
    }
    boolean dfs(char[][] board,String word,int u,int x,int y){
        // 定义终止条件
        if (board[x][y]!=word.charAt(u))
            return false;
        if (u==word.length()-1)
            return true;
        // 枚举四个方向并且避免反方向寻找或者重复寻找
        char temp=board[x][y];
        board[x][y]='*';
        for (int i = 0; i < 4; i++) {
            int a=x+dx[i];
            int b=y+dy[i];
            if (a<0||a>=n||b<0||b>=m) continue;
            if (board[a][b]=='*') continue;
            if (dfs(board,word,u+1,a,b))
                return true;
        }
        board[x][y]=temp;
        return false;
    }
}
