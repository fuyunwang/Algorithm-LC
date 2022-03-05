package com.gopher.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Title DFS
 * @Author fyw
 * @Date 2022-02-21 14:00
 * @Description
 */
public class DFS {
    // 树的重心
    static class TreeWeight{
        static int N = 100010,M = N * 2;
        static int[] h = new int[N];
        static int[] e = new int[M];
        static int[] ne = new int[M];
        static int idx = 0;
        static int n;
        static int ans = N;
        static boolean[] st = new boolean[N];
        public static void add(int a,int b)
        {
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx ++;
        }
        //以x为根的子树中点的数量，注意递归函数的宏观意义，局部变量定义sum和res，每次递归返回所有子树的数据并进行操作，最后再返回
        public static int dfs(int x)
        {
            st[x] = true; // 标记一下，已经被搜索过
            int sum = 1;
            int res = 0;//记录切掉x的根的其他子树的最大值
            for(int i = h[x];i != -1;i = ne[i])
            {
                int j = e[i];
                if(!st[j])
                {
                    int s = dfs(j);
                    res = MathTemplate.max(res, s);         // 当前节点下子树节点最大值
                    sum += s;
                }
            }
            res = MathTemplate.max(res, n - sum);
            ans = MathTemplate.min(ans, res);
            return sum ;
        }
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(reader.readLine());
            Arrays.fill(h, -1);
            for(int i = 0;i < n - 1;i++)
            {
                String[] str = reader.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                add(a,b);
                add(b,a);
            }
            dfs(1);
            System.out.println(ans);
        }
    }
}
