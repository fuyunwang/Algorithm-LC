package com.gopher.ending.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title TreeDp
 * @Author fyw
 * @Date 2022-03-12 13:50
 * @Description
 */
public class TreeDp{
    static class CodeWing0{
        // 树的重心
        // 删除某个点之后其他的连通块中最多节点的数量最少
        static int N=100010,M=2*N;
        static int n;
        static int[] h=new int[N];
        static int[] e=new int[M];
        static int[] ne=new int[M];
        static int idx=0;
        static boolean[] visited=new boolean[N];

        static int ans=N;

        public static void main(String[] args) throws IOException{
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

        static int dfs(int u){      // 返回以u为根节点的子树的大小
            visited[u]=true;
            int sum=1;// 记录以u为根节点的子树的大小
            int res=0;// 记录最大值
            for (int i = h[u]; i != -1; i=ne[i]) {
                int j=e[i];
                if (!visited[j]){
                    int s=dfs(j);
                    res=Math.max(res,s);
                    sum+=s;
                }
            }
            // 更新最大值
            res=Math.max(res,n-sum);
            ans=Math.min(ans,res);
            return sum;
        }

        static void add(int a,int b){
            e[idx]=b;
            ne[idx]=h[a];
            h[a]=idx++;
        }
    }
    static class CodeWing1{
        // 没有上司的舞会
        /**
         * f[u,0]表示所有从以u为根的子树中选且不选u的方案,f[u,1]表示所有从以u为根的子树中选且选u的方案
         */
        static int N=6010;
        static int[] happy=new int[N];
        // 树是一种无向图，建树
        static int[] e=new int[N];
        static int[] h=new int[N];
        static int[] ne=new int[N];
        static int idx=0;
        // 标记当前节点是否有父节点，主要是用于找到根节点，这也是用图表示书不可或缺的一步
        static boolean[] hasFather=new boolean[N];
        // 状态转移
        static int[][] f=new int[N][2];
        public static void main(String[] args) throws IOException {
            // 读入数据
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                happy[i]=scanner.nextInt();
            }
            // 建图
            Arrays.fill(h,-1);

            for (int i = 0; i < n-1; i++) {
                int a=scanner.nextInt();
                int b=scanner.nextInt();//b 是a的父节点
                hasFather[a]=true;
                add(b,a);
            }
            int root=1;
            while (hasFather[root]) root++;
            // 找到了根节点之后开始遍历
            dfs(root);
            System.out.println(Math.max(f[root][1],f[root][0]));
        }
        static void add(int a,int b){
            e[idx]=b;
            ne[idx]=h[a];
            h[a]=idx++;
        }

        static void dfs(int root){
            f[root][1]=happy[root];
            for (int i = h[root]; i!=-1; i=ne[i]) {
                int j=e[i];
                dfs(j);
                f[root][1]+=f[j][0];
                f[root][0]+=Math.max(f[j][0],f[j][1]);
            }
        }
    }
    static class CodeWing2{
        // 边无权值树的最长路径
        // 边有权值的树的最长路径
        static int N=100010,M=2*N;
        static int[] h=new int[N];
        static int[] e=new int[M];
        static int[] ne=new int[M];
        static int[] w=new int[M];
        static int idx=0;
        // 避免走回头路，保证无向边始终向下遍历
        static boolean[] visited=new boolean[N];
        // 记录最大结果
        static int res=0;
        public static void main(String[] args) throws IOException{
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            Arrays.fill(h,-1);
            int n=Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < n-1; i++) {
                String[] str=reader.readLine().trim().split(" ");
                int a=Integer.parseInt(str[0]);
                int b=Integer.parseInt(str[1]);
                int c=Integer.parseInt(str[2]);
                add(b,a,c);
                add(a,b,c);
            }
            dfs(1,-1);
            System.out.println(res);
        }
        static void add(int a,int b,int c){
            e[idx]=b;
            w[idx]=c;
            ne[idx]=h[a];
            h[a]=idx++;
        }
        static int dfs(int root,int father){       // dfs记录从当前点往下走的最长路径，但是本体要求最长和次长路径之和
            int dist=0;
            int max1=0,max2=0;
            visited[root]=true;
            for (int i = h[root]; i != -1 ; i=ne[i]) {
                int j=e[i];
                if (visited[j])
                    continue;
                int d=dfs(j,root)+w[i];// 记录当前方式的路径
                dist=Math.max(d,dist);
                if (d>=max1){
                    max2=max1;
                    max1=d;
                }else if(d>max2){
                    max2=d;
                }
            }
            res=Math.max(res,max1+max2);
            return dist;
        }
    }
    static class CodeWing3{
        // 树的中心
        /**
         * 考虑每一个点，求其向下走的最长距离以及向上走的最长距离
         * 其中向上走到的第一个父节点，需要考虑其向上走的最大距离、向下走（包含当前点的次大距离和不包含当前点的最大距离）中的最大距离
         */
        static int N=10010,M=2*N;
        static int[] h=new int[N];
        static int[] e=new int[M];
        static int[] ne=new int[M];
        static int[] w=new int[M];
        static int idx=0;
        // 存储当前点往上走和往下走的最长路径
        static int[] down1=new int[N];
        static int[] down2=new int[N];
        static int[] up=new int[N];
        // 记录往上走时是由哪个节点过来的
        static int[] p1=new int[N];
        static int[] p2=new int[N];

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            Arrays.fill(h,-1);
            for (int i = 0; i < n-1; i++) {
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                int c=scanner.nextInt();
                add(a,b,c);
                add(b,a,c);
            }

            dfs1(1,-1);
            dfs2(1,-1);

            int res=Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                res=Math.min(res,Math.max(down1[i],up[i]));
            }
            System.out.println(res);
        }

        static void add(int a,int b,int c){
            e[idx]=b;
            w[idx]=c;
            ne[idx]=h[a];
            h[a]=idx++;
        }

        static int dfs1(int root,int father){
            down1[root]=Integer.MIN_VALUE;
            down2[root]=Integer.MIN_VALUE;
            for (int i = h[root]; i !=-1 ; i=ne[i]) {
                int j=e[i];
                if (j==father){
                    // 向下走的过程中出现回头不可以
                    continue;
                }
                int d=dfs1(j,root)+w[i];
                if (d>=down1[root]){
                    down2[root]=down1[root];
                    down1[root]=d;
                    p2[root]=p1[root];
                    p1[root]=j;
                }else if (d>down2[root]){
                    down2[root]=d;
                    p2[root]=j;
                }
            }
            if (down1[root]==Integer.MIN_VALUE){
                // 叶子节点没有更新
                down1[root]=0;
                down2[root]=0;
            }
            return down1[root];
        }

        static int dfs2(int root,int father){
            for (int i = h[root]; i != -1 ; i=ne[i]) {
                int j=e[i];
                if (j==father)
                    continue;
                if (p1[root]==j){
                    up[j]=Math.max(up[root], down2[root])+w[i];// 从当前点上来的说明只能次大值来更新
                }else{
                    up[j]=Math.max(up[root], down1[root])+w[i];  // i有边的含义 w[i]表示边权
                }
                dfs2(j,root);// 继续跟更新其他的点向上走的最大值
            }
            return up[root];
        }
    }

    static class Code310{
        // 最小高度树
    }

}