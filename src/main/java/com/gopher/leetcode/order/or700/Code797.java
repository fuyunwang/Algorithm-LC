package com.gopher.leetcode.order.or700;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code797
 * @Author fyw
 * @Date 2022/2/9 14:50
 * @Description: 所有可能的路径
 */
public class Code797 {
    List<List<Integer>> res=new ArrayList<>();
    int[][] g;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g=graph;
        n= g.length;
        backtrack(0,new LinkedList<>());
        return res;
    }
    public void backtrack(int node, LinkedList<Integer> path){
        path.add(node);
        if (node==n-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int adj:g[node]){
            backtrack(adj,path);
            path.pollLast();
        }
    }
}
