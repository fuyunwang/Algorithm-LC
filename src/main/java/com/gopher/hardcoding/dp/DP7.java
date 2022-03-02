package com.gopher.hardcoding.dp;

import java.io.*;
import java.util.*;

/**
 * @Title DP7
 * @Author fyw
 * @Date 2022-02-26 13:22
 * @Description 树形DP
 */
public class DP7 {
    static class Code1{
        // 树的直径
        /**
         * 一般情况下，没有边权的树：任取一点找到距离这点最远的点，然后找到距离最远点最远的点，两点之间就是最远直径。
         * BFS/DFS
         */
        /**
         * 从任意结点开始，找到每个结点且经过该节点向下走的最大长度d1和次大长度d2，则经过该节点的最大长度是d1 + d2
         *
         * dfs(u,father)表示找到u点往下走的最大长度d1
         */
        static int N = 10010;
        static int M = N * 2;
        static int[] h = new int[N];
        static int[] e = new int[M];
        static int[] ne = new int[M];
        static int[] w = new int[M];
        static int idx = 0;
        static int ans = 0;
        static void add(int a,int b,int c)
        {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx ++;
        }
        //找到u点往下走的最大长度,father参数保证只能往下走不能往上走
        static int dfs(int u,int father)
        {
            int d1 = 0;//最大值，函数内部定义值会在递归过程中重新赋值，相当于只用了一次初始值。看函数的返回结果知道每次返回最大值
            int d2 = 0;//次大值
            // 模板代码，找到当前节点为根节点下的最大长度
            for(int i = h[u];i != -1;i = ne[i])
            {
                int j = e[i];
                if(j == father) continue;
                int d = dfs(j,u) + w[i];

                if(d > d1) {d2 = d1; d1 = d;}
                else if(d > d2) {d2 = d;}
            }
            ans = Math.max(ans, d1 + d2);
            return d1;
        }
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine().trim());
            Arrays.fill(h,-1);
            for(int i = 0;i < n - 1;i ++)
            {
                String[] s1 = reader.readLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                int c = Integer.parseInt(s1[2]);
                add(a,b,c);
                add(b,a,c);
            }
            dfs(1,-1);
            System.out.println(ans);
        }
    }
}
