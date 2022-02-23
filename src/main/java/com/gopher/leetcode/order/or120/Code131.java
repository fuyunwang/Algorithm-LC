package com.gopher.leetcode.order.or120;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Code131
 * @Author fyw
 * @Date 2022/2/8 21:57
 * @Description: 分割回文串I
 * 指数次方，分割方案
 */
public class Code131 {
    /**
     * 回文串，递推.f[i,j]快速判断[i,j]是否是回文串
     * @param s
     * @return
     */
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();
    boolean[][] g;           // 快速判断是否是回文串
    public List<List<String>> partition(String s) {
        int n = s.length();

        g= new boolean[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j <= i; j ++){
                if(i == j) g[i][j] = true;
                else if(s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || g[j + 1][i - 1]))
                    g[j][i] = true;
            }
        }

        dfs(0, s);  // 从第0个位置开始搜索
        return ans;
    }

    void dfs(int u, String s){
        if(u == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = u; i < s.length(); i ++){
            if(g[u][i]){
                path.add(s.substring(u, i + 1));
                dfs(i + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }
}
