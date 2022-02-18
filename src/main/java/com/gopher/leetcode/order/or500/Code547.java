package com.gopher.leetcode.order.or500;

/**
 * @Title Code547
 * @Author fyw
 * @Date 2022/2/18 22:24
 * @Description: 省份数量
 * 并查集
 */
public class Code547 {
    int[] p;
    int find(int x){    // 并查集找父节点
        if (x!=p[x])
            p[x]=find(p[x]);
        return p[x];
    }
    void union(int x,int y){    // 把y的父节点挂在x上
        p[find(y)]=find(x);
    }
    public int findCircleNum(int[][] isConnected) {
        // 初始化并查集，每个索引的父节点是自己
        int n=isConnected.length;
        p=new int[n];
        for (int i = 0; i < n; i++) {
            p[i]=i;
        }
        // 遍历每一个点，对于存在边的位置合并。注意isConnected的含义就是其上的值代表i j 之间是否有边
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j&&isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        // 注意统计的技巧
        int res=0;
        for (int i = 0; i < n; i++) {
            if (p[i]==i)
                res++;
        }
        return res;
    }
}
