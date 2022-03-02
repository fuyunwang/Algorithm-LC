package com.gopher.leetcode.types;

/**
 * @Title DFS
 * @Author fyw
 * @Date 2022-03-02 9:48
 * @Description
 */
public class DFS {
    static class Code1{ // 树的直径，找值最大的两条子路，然后求和
        int N = 10010;
        int M = N * 2;
        int[] h = new int[N];
        int[] e = new int[M];
        int[] ne = new int[M];
        int[] w = new int[M];
        int idx = 0;
        int ans = 0;
        //找到u点往下走的最大长度,father参数保证只能往下走不能往上走
        int dfs(int u,int father)
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
    }
    static class Code2{ // 树的重心，重心是指树中的一个结点，如果将这个点删除后，剩余各个连通块中点数的最大值最小，
        int dfs(int x)    //以x为根的子树中点的数量
        {
            st[x] = true; // 标记一下，已经被搜索过
            int sum = 1;  // sum值表示当前节点作为根节点+1
            int res = 0;    //记录切掉x的根的其他子树的最大值
            for(int i = h[x];i != -1;i = ne[i])
            {
                int j = e[i];
                if (st[j]) continue;
                int s = dfs(j);
                res = Math.max(res, s);         // 当前节点下子树节点最大值
                sum += s;
            }
            res = Math.max(res, n - sum);       // 除去当前节点作为子树根节点时的其余节点数量
            ans = Math.min(ans, res);
            return sum ;
        }
        int N = 100010,M = N * 2;
        int[] h = new int[N];
        int[] e = new int[M];
        int[] ne = new int[M];
        int idx = 0;
        int n;
        int ans = N;
        boolean[] st = new boolean[N];
    }
}
