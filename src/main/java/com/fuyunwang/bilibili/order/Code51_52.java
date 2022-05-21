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
        List<List<String>> res=new ArrayList<>();
        char[][] g;
        boolean[] row=new boolean[N];
        boolean[] dg=new boolean[N];
        boolean[] udg=new boolean[N];
        int n;
        public List<List<String>> solveNQueens(int n) {
            this.n=n;
            g=new char[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(g[i],'.');
            }
            dfs(0);
            return res;
        }

        void dfs(int y){    // 与数独一样，采用x、y来遍历整个矩阵
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
        int n;
        boolean[] row;
        boolean[] dg;
        boolean[] udg;
        char[][] g;

        public int totalNQueens(int n) {
            this.n=n;
            row=new boolean[n];
            dg=new boolean[n*2];
            udg=new boolean[n*2];
            g=new char[n][n];
            return dfs(0);  // 枚举策略，外层参数枚举每一列，内层循环枚举每一行
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
