package com.fuyunwang.bilibili.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code51_52
 * @Author fyw
 * @Date 2022/5/21 19:51
 * @Description: N皇后
 */
public class Code51_52 {
    static class Code51{
        int N=20;
        boolean[] row=new boolean[N];
        boolean[] dg=new boolean[N];    // 对角线1
        boolean[] udg=new boolean[N];   // 对角线2
        char[][] g;
        int n;
        List<List<String>> res=new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            this.n=n;
            g=new char[N][N];
            for (int i = 0; i < g.length; i++) {
                Arrays.fill(g[i],'.');
            }
            dfs(0);
            return res;
        }
        void dfs(int y){
            if (y==n){
                List<String> path=new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder sb=new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        sb.append(g[i][j]);
                    }
                    path.add(sb.toString());
                }
                res.add(path);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!row[i]&&!udg[y-i+n]&&!dg[y+i]){
                    row[i]=udg[y-i+n]=dg[y+i]=true;
                    g[i][y]='Q';
                    dfs(y+1);
                    g[i][y]='.';
                    row[i]=udg[y-i+n]=dg[y+i]=false;
                }
            }
        }
    }
    static class Code52{
        boolean[] row;
        boolean[] dg;    // 对角线1
        boolean[] udg;   // 对角线2
        int n;
        char[][] g;
        public int totalNQueens(int n) {
            this.n=n;
            g=new char[n][n];
            row=new boolean[n];
            dg=new boolean[2*n];
            udg=new boolean[2*n];
            return dfs(0);
        }
        int dfs(int y){
            if (y==n){
                return 1;
            }
            int res=0;
            for (int i = 0; i < n; i++) {
                if (!row[i]&&!udg[y-i+n]&&!dg[y+i]){
                    row[i]=udg[y-i+n]=dg[y+i]=true;
                    res+=dfs(y+1);
                    row[i]=udg[y-i+n]=dg[y+i]=false;
                }
            }
            return res;
        }
    }
}
