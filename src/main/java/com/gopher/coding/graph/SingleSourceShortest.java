package com.gopher.coding.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Title SingleSourceShortest
 * @Author fyw
 * @Date 2022-02-21 15:35
 * @Description 单源最短路径
 * 迪杰斯特拉算法
 *
 * 1. 初始化: dist[0]=0， dist[others]=无穷
 * 2. 遍历所有点，找到距离初始点最近的点并更新距离，然后将当前点纳入已确定集合
 * 3. 根据已确定集合中的点来更新其他点的距离
 */
public class SingleSourceShortest {
    // 朴素版边权全为正的，
    static class Code1{
        static int N = 510;
        static int[][] g = new int[N][N]; //稠密图使用邻接矩阵存储
        static int[] dist = new int[N];  // 记录源点到每个点的juli
        static boolean[] st = new boolean[N]; //相当于s集合，确定了和1号点的最短距离的点加入到s集合中
        static int n;
        static int max = 5000000;

        static int dijkstra(){
            //初始化
            Arrays.fill(dist, max);
            dist[1] = 0;
            //循环n-1次，将除1节点外的n-1个点加入s集合中
            for(int i=0; i<n-1; i++){
                //找到当前距离1号点最近的点
                int t = -1;
                for(int j = 1; j<=n ;j++){
                    if(st[j]) continue;
                    if(t==-1||dist[j]<dist[t]){
                        t = j;
                    }
                }
                st[t] = true;       // 此时找到的t就是当前循环找到的距离初始点最近的点
                //更新其它节点到1号点的距离
                for(int j=1; j<=n; j++){
                    if(dist[j] > dist[t] + g[t][j]) dist[j] = dist[t]+g[t][j];
                }
            }
            if(dist[n]==max) return -1;
            else return dist[n];
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] cur = in.readLine().split(" ");
            n = Integer.parseInt(cur[0]);
            int m = Integer.parseInt(cur[1]);

            //初始化g为正无穷，解决重边的问题
            for(int i=1; i<=n; i++) Arrays.fill(g[i], max);

            while(m-->0){
                String[] arr = in.readLine().split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int c = Integer.parseInt(arr[2]);

                g[a][b] = Math.min(g[a][b], c);
            }
            System.out.println(dijkstra());
        }
    }

    // 堆优化版本的
    static class Code2{
        // 求1号点到n号点的最短路，如果不存在则返回-1
        public static int dijkstra() {
            //维护当前未在st中标记过且离源点最近的点，//距离值+点编号
            PriorityQueue<PIIs> queue = new PriorityQueue<>();
            Arrays.fill(dist, INF);
            dist[1] = 0;
            queue.add(new PIIs(0,1));
            while(!queue.isEmpty()) {
                //1、找到当前未在s中出现过且离源点最近的点
                PIIs p = queue.poll();
                int distance = p.getFirst();
                int t = p.getSecond();
                if(st[t]) continue;
                //2、将该点进行标记
                st[t] = true;
                //3、用t更新其他点的距离
                for(int i = h[t];i != -1;i = ne[i]) {
                    int j = e[i];
                    if(dist[j] > distance + w[i]) {
                        dist[j] = distance + w[i];
                        queue.add(new PIIs(dist[j],j));
                    }
                }
            }
            if(dist[n] == INF) return -1;
            return dist[n];
        }

        public static void main(String[] args) throws IOException{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = reader.readLine().split(" ");
            n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);
            Arrays.fill(h, -1);
            while(m -- > 0)
            {
                String[] str2 = reader.readLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                int c = Integer.parseInt(str2[2]);
                add(a,b,c);
            }
            System.out.println(dijkstra());
        }
        static class PIIs implements Comparable<PIIs>{
            private int first;//距离值
            private int second;//点编号

            public int getFirst() {
                return this.first;
            }
            public int getSecond() {
                return this.second;
            }
            public PIIs(int first,int second) {
                this.first = first;
                this.second = second;
            }
            @Override
            public int compareTo(PIIs o) {
                // TODO 自动生成的方法存根
                return Integer.compare(first, o.first);
            }
        }
        static int N = 100010;
        static int n;
        static int[] h = new int[N];
        static int[] e = new int[N];
        static int[] ne = new int[N];
        static int[] w = new int[N];
        static int idx = 0;
        static int[] dist = new int[N];// 存储1号点到每个点的最短距离
        static boolean[] st = new boolean[N];
        static int INF = 0x3f3f3f3f;//设置无穷大
        public static void add(int a,int b,int c) {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx ++;
        }
    }


    // SPFA处理负权边
    static class Code3{
        static int spfa(){
            Arrays.fill(dist, max);
            dist[1] = 0;
            st[1] = true;
            //声明一个队列保存更新过的节点
            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            while(!q.isEmpty()){
                int cur = q.poll();
                st[cur] = false;
                for(int i=h[cur]; i!=-1; i=ne[i]){
                    int j = e[i];
                    //如果当前节点可以被更新，就做更新操作，并将该节点加入到队列中
                    if(dist[j] > dist[cur]+w[i]){
                        dist[j] = dist[cur] + w[i];
                        if(!st[j]){
                            q.add(j);
                            st[j] = true;
                        }
                    }
                }
            }
            if(dist[n] == max) return -1;
            else return dist[n];
        }
        public static void main(String[]args) throws IOException{
            Arrays.fill(h, -1);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] cur = in.readLine().split(" ");
            n = Integer.parseInt(cur[0]);
            int m = Integer.parseInt(cur[1]);

            while(m-->0){
                String[] arr = in.readLine().split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int c = Integer.parseInt(arr[2]);

                add(a, b, c);
            }

            int t = spfa();
            if(t==-1) System.out.println("impossible");
            else System.out.println(t);
        }
        static int N = 100010;
        static int[] h = new int[N];
        static int[] e = new int[N];
        static int[] ne = new int[N];
        static int[] w = new int[N];
        static int[] dist = new int[N];     // 当前1号点到其他点的最短距离
        static boolean[] st = new boolean[N];
        static int idx;
        static int max = (int)1e9;
        static int n,m;

        static void add(int a, int b, int c){
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx++;
        }
    }
    // SPFA判断是否有负环
    static class Code4{
        static int n;
        static int m;
        static int N = 2010;
        static int M = 10010;
        static int[] h = new int[N];
        static int[] e = new int[M];
        static int[] ne = new int[M];
        static int[] w = new int[M];
        static int idx = 0;
        static int[] dist = new int[N];//记录虚拟点到x的最短距离
        static int[] cnt = new int[N];//从虚拟点到x经过的边数
        static boolean[] st = new boolean[N];
        public static void add(int a,int b,int c) {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx ++;

        }
        public static boolean spfa() {
            Queue<Integer> queue = new LinkedList<Integer>();
            // 将所有点进入队列，
            // 判断是否存在负环，并非判断是否存在从1开始的负环，因此需要将所有的点都加入队列中，更新周围的点
            for(int i = 1;i <= n;i++) {
                queue.add(i);
                st[i] = true;
            }
            while(!queue.isEmpty()) {
                int t = queue.poll();
                st[t] = false;
                for(int i = h[t]; i != -1;i = ne[i]) {
                    int j = e[i];
                    if(dist[j] > dist[t] + w[i]) {
                        dist[j] = dist[t] + w[i];
                        cnt[j] = cnt[t] + 1;
                        if(cnt[j] >= n) return true;
                        if(!st[j]) {
                            queue.add(j);
                            st[j] = true;
                        }
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = reader.readLine().split(" ");
            n = Integer.parseInt(str1[0]);
            m = Integer.parseInt(str1[1]);
            Arrays.fill(h, -1);
            while(m -- > 0) {
                String[] str2 = reader.readLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                int c = Integer.parseInt(str2[2]);
                add(a,b,c);
            }
            if(spfa()) System.out.println("Yes");
            else System.out.println("No");
        }
    }

}