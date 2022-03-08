package com.gopher.leetcode.types.graph;

import java.util.*;

/**
 * @Title DFS2
 * @Author fyw
 * @Date 2022-03-08 19:27
 * @Description
 */
public class DFS2 {
    static class Code756{

        Map<String,List<Character>> map=new HashMap<>();
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            for (String allow:allowed){
                map.computeIfAbsent(allow.substring(0,2),k->new ArrayList<>()).add(allow.charAt(2));// 准备选择列表
            }
            return dfs(bottom,"",0);
        }

        boolean dfs(String bottom,String up,int index){ // 参数分别是当前底部字符串、目前顶部字符串、底部字符串考虑的索引位置
            if (bottom.length()==1)
                return true;
            if (index==bottom.length()-1)
                return dfs(up,"",0);
            for (char c:map.getOrDefault(bottom.substring(index,index+2), Collections.emptyList())){
                if (dfs(bottom,up+c,index+1)){
                    return true;// 做出了正确的选择
                }
            }
            return false;
        }

    }
}
