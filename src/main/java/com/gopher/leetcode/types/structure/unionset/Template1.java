package com.gopher.leetcode.types.structure.unionset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-08 10:10
 * @Description
 */
public class Template1 {
    static class Code924 {
        // 维护连通块的大小用并查集
        int[] p,s,c;// p表示并查集数组，s表示并查集大小，c表示并查集中感染的点数
        public int minMalwareSpread(int[][] graph, int[] initial) {
            // 并查集使用一个点代表一个集合，所以这里s代表每一个集合的大小，c表示集合的感染点数
            int n=graph.length;
            p=new int[n];
            s=new int[n];
            c=new int[n];
            for (int i = 0; i < n; i++) {
                p[i]=i;
                s[i]=1;
                c[i]=0;
            }
            // 本题的graph中的矩阵值只衡量了点之间的连通关系
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j]==1&&find(i)!=find(j)){
                        s[find(i)]+=s[find(j)];
                        p[find(j)]=p[find(i)];
                    }
                }
            }
            // 当前集合感染的点数
            for (int x:initial)
                c[find(x)]++;
            int rs=-1;// 表示可以拯救的点数，尽量拯救更多的点
            int rp=Integer.MAX_VALUE;// 点的编号，最多可以拯救点的集合的编号
            for (int x:initial){
                if (rs==-1)
                    rp=Math.min(rp,x);
                if (c[find(x)]==1){
                    // 此时可以拯救
                    if (rs<s[find(x)]){
                        rs=s[find(x)];
                        rp=x;
                    }else if (rs==s[find(x)]){
                        rp=Math.min(rp,x);
                    }
                }
            }
            return rp;
        }
        int find(int x){
            if (p[x]!=x){
                p[x]=find(p[x]);
            }
            return p[x];
        }
    }

    static class Code765 {

    }
    static class Code990{
        int[] parent;
        int find(int x){
            if (parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public boolean equationsPossible(String[] equations) {
            parent=new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i]=i;
            }
            for (String eq:equations){
                int a=eq.charAt(0)-'a';
                int b=eq.charAt(3)-'a';
                char c=eq.charAt(1);
                if (c=='='){
                    if (find(a)!=find(b)){
                        parent[find(a)]=find(b);
                    }
                }
            }
            for (String eq:equations){
                int a=eq.charAt(0)-'a';
                int b=eq.charAt(3)-'a';
                char c=eq.charAt(1);
                if (c=='!'){
                    if (find(a)==find(b)){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static class Code924_928 {
        //  尽量减少恶意软件的传播
        int[] p, s, c;

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public int minMalwareSpread(int[][] graph, int[] initial) {
            int n = graph.length;
            p = new int[n];
            s = new int[n];
            c = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                s[i] = 1;
                c[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > 0 && find(i) != find(j)) {
                        s[find(i)] += s[find(j)];
                        p[find(j)] = find(i);
                    }
                }
            }
            for (int i : initial) c[find(i)]++;
            int rs = -1, rp = Integer.MAX_VALUE;
            for (int x : initial) {
                if (rs == -1) rp = Math.min(rp, x);
                if (c[find(x)] == 1) {
                    if (rs < s[find(x)]) {
                        rs = s[find(x)];
                        rp = x;
                    } else if (rs == s[find(x)]) {
                        rp = Math.min(rp, x);
                    }
                }
            }
            return rp;
        }
    }

    static class Code827 {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int n, m;
        int[] p, size;

        public int largestIsland(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            p = new int[n * m];
            size = new int[n * m];
            for (int i = 0; i < n * m; ++i) {
                p[i] = i;
            }
            int max = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) {
                        size[i * m + j] = 1;
                        max = 1;
                    }
                }
            }


            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) {
                        int x = i * m + j;
                        for (int k = 0; k < 4; ++k) {
                            int a = i + dx[k];
                            int b = j + dy[k];
                            if (a < 0 || a >= n || b < 0 || b >= m || grid[a][b] != 1) continue;
                            int y = a * m + b;
                            int fx = find(x);
                            int fy = find(y);
                            if (fx != fy) {
                                p[fy] = fx;
                                size[fx] += size[fy];
                                max = Math.max(max, size[fx]);
                            }
                        }
                    }
                }
            }
            if (max == 0) return 1;

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (grid[i][j] == 1) continue;
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; ++k) {
                        int a = i + dx[k];
                        int b = j + dy[k];
                        if (a < 0 || a >= n || b < 0 || b >= m || grid[a][b] == 0) continue;
                        set.add(find(a * m + b));
                    }
                    int sum = 0;
                    for (int t : set) {
                        sum += size[t];
                    }
                    max = Math.max(max, sum + 1);
                }
            }
            return max;
        }

        int find(int x) {
            if (x != p[x]) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

    }
}
