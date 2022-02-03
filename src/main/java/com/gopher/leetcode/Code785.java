package com.gopher.leetcode;

/**
 * @Title Code785
 * @Author fyw
 * @Date 2022/2/3 19:15
 * @Description: 二分图的判定
 */
public class Code785 {

    int[][] graph;
    int[] colors;//记录每个顶点的颜色
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        this.graph=graph;
        int V=graph.length;//得到图的节点
        colors=new int[V];
        visited=new boolean[V];
        // 对图中的每一个连通分量进行检测，如果有一个联通分量不是二分图，整个图就不是二分图
        for (int i = 0; i < V; i++) {
            if (!visited[i]&&!dfs(i,0)) // 去访问然后发现有矛盾
                return false;
        }
        return true;
    }
    // 从点v出发，检测是否满足二分图的性质
    boolean dfs(int v, int color){
        visited[v]=true;
        colors[v]=color;
        for (int w:graph[v]){
            if (!visited[w]){
                if (!dfs(w,1-color)) // 递归染色发现是否有矛盾
                    return false;
            }else{
                //访问过的也要检测是否有矛盾
                if (colors[v]==colors[w])
                    return false;
            }
        }
        return true;
    }

}
