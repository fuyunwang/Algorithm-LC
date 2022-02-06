package com.gopher.leetcode;

import java.util.HashSet;

/**
 * @Title Code1079
 * @Author fyw
 * @Date 2022/2/6 12:01
 * @Description: 活字印刷
 * 经典回溯
 */
public class Code1079 {
    public int numTilePossibilities(String tiles) {
        int[] freq=new int[26];
        for (char c: tiles.toCharArray())
            freq[c-'A']++;
        return dfs(freq);
    }
    int dfs(int[] freq){
        int res=0;
        for (int i = 0; i < 26; i++) {
            if (freq[i]<=0)
                continue;
            freq[i]--;
            res++;
            res+=dfs(freq);
            freq[i]++;
        }
        return res;
    }

    //方法2
    public int numTile2(String tiles){
        boolean[] visited=new boolean[tiles.length()];
        return dfs2(tiles,new HashSet<>(),visited,new StringBuilder())-1;//空减去
    }
    public int dfs2(String tiles, HashSet<String> set,boolean[] visited,StringBuilder sb){
        set.add(sb.toString());

        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]){
                visited[i]=true;
                sb.append(tiles.charAt(i));
                dfs2(tiles,set,visited,sb);
                sb.deleteCharAt(sb.length()-1);
                visited[i]=false;
            }
        }
        return set.size();
    }
}
