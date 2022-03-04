package com.gopher.leetcode.types.backtrack;

import java.util.*;

/**
 * @Title BacktrackTemplate2
 * @Author fyw
 * @Date 2022/1/29 20:09
 * @Description: 做选择生成结果
 */
public class BacktrackTemplate2 {
    static class Code17{
        // 全排列变形
        List<String> res=new LinkedList<>();
        HashMap<String,String> map = new HashMap<String,String>()
        {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        public List<String> letterCombinations(String digits) {
            if(digits.length()==0){
                return Collections.emptyList();
            }
            backtrack(digits,0,new StringBuilder());
            return res;
        }
        void backtrack(String digits,int index,StringBuilder sb){
            if (index==digits.length()){
                res.add(new StringBuilder(sb).toString());
                return;
            }
            String substring = digits.substring(index, index + 1);
            for (int i = 0; i < map.get(substring).length(); i++) { // 对于当前字符可进行的选择进行遍历
                sb.append(map.get(substring).charAt(i));
                backtrack(digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
    static class Code22{
        List<String> res=new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            backtrack(n,0,0,new StringBuilder());
            return res;
        }
        void backtrack(int n,int l,int r,StringBuilder sb){
            if (l==n&&r==n){
                res.add(new StringBuilder(sb).toString());
                return;
            }
            if (l<n){
                backtrack(n,l+1,r,sb.append("("));
                sb.deleteCharAt(sb.length()-1);
            }
            if (r<n&&r<l){
                backtrack(n,l,r+1,sb.append(")"));
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    static class Code37{
        // 数独
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][][] cell=new boolean[3][3][9];
        char[][] board;
        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j]!='.'){
                        int cur=board[i][j]-'1';
                        row[i][cur]=col[j][cur]=cell[i/3][j/3][cur]=true;
                    }
                }
            }
            this.board=board;
            backtrack(0,0); // 从第0行第0列开始放
        }
        boolean backtrack(int x,int y){
            if (y==9){
                x++;
                y=0;
                if (x==9)
                    return true;
            }
            if (board[x][y]!='.')
                return backtrack(x,y+1);
            for (int i = 0; i < 9; i++) {
                if (!row[x][i]&&!col[y][i]&&!cell[x/3][y/3][i]){
                    char t= (char) (i+'1');
                    row[x][i]=col[y][i]=cell[x/3][y/3][i]=true;
                    board[x][y]=t;
                    if (backtrack(x,y+1)){
                        return true;
                    }
                    board[x][y]='.';
                    row[x][i]=col[y][i]=cell[x/3][y/3][i]=false;
                }
            }
            return false;
        }
    }
    static class Code51{
        // N皇后
        int N=10;
        boolean[] row=new boolean[N];
        boolean[] dg=new boolean[N];    // x-i+n
        boolean[] udg=new boolean[N];   // x+i
        char[][] board=new char[N][N];
        List<List<String>> res=new LinkedList<>();
        public List<List<String>> solveNQueens(int n) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j]='.';
                }
            }
            backtrack(0,n);
            return res;
        }
        void backtrack(int x,int n){ // 按行放
            if (x==n){
                List<String> list=new ArrayList<>();
                for (int i = 0; i < n; i++) {
                   StringBuilder sb=new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        sb.append(board[i][j]);
                    }
                    list.add(sb.toString());
                }
                res.add(list);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!row[i]&&!dg[x-i+n]&&!udg[x+i]){
                    row[i]=dg[x-i+n]=udg[x+i]=true;
                    board[x][i]='Q';
                    backtrack(x+1,n);   // 下一行开始
                    board[x][i]='.';
                    row[i]=dg[x-i+n]=udg[x+i]=false;
                }
            }
        }
    }
}
