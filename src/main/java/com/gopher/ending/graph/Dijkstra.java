package com.gopher.ending.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Title Dijkstra
 * @Author fyw
 * @Date 2022/3/16 22:35
 * @Description:
 */
public class Dijkstra {
    static class CodeWing1{
        static class Code1{
            // 朴素稠密有向图
            static int N=510;
            static int[][] g=new int[N][N]; // 记录图
            static int[] dist=new int[N]; // 记录1号点到其他各点的距离
            static boolean[] visited=new boolean[N]; // 记录当前点是否被问过
            // 记录点的个数
            static int n;
            static int INF = 0x3f3f3f3f;//设置无穷大
            public static void main(String[] args) throws IOException {
                BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
                String[] str=reader.readLine().trim().split(" ");
                n=Integer.parseInt(str[0]);
                int m=Integer.parseInt(str[1]);
                // 首先初始化所有距离为正无穷
                for (int i = 1; i <= n; i++) {
                    Arrays.fill(g[i],INF);
                }
                while (m--!=0){ // 读入边的信息
                    String[] str1=reader.readLine().trim().split(" ");
                    int a=Integer.parseInt(str1[0]);
                    int b=Integer.parseInt(str1[1]);
                    int c=Integer.parseInt(str1[2]);
                    g[a][b]=Math.min(g[a][b],c);// 若有重边选择权值最小的记录
                }
                System.out.println(dijkstra());
            }
            static int dijkstra(){      // 带权值的图，求1号点到最后一个点的信息，不能用bfs
                Arrays.fill(dist,INF);
                dist[1]=0;
                // 一共n个点，遍历n次
                for (int i = 0; i < n; i++) {
                    // 第一轮找到所有点中没被访问过的距离最近的点
                    int t=-1;
                    for (int j = 1; j <= n; j++) {
                        if (!visited[j]&&(t==-1||dist[t]>dist[j])){
                            t=j;
                        }
                    }
                    visited[t]=true;
                    // 利用当前点来更新其他点的信息
                    for (int j = 1; j <= n; j++) {
                        dist[j]=Math.min(dist[j],dist[t]+g[t][j]);
                    }
                }
                return dist[n]==INF?-1:dist[n];
            }
        }
        static class Code2{
            // 堆优化稀疏图
            static int N=100010,INF=0X3f3f3f;
            static boolean[] visited=new boolean[N];
            static int[] dist=new int[N];

            static int[] h=new int[N];
            static int[] e=new int[N];
            static int[] ne=new int[N];
            static int[] w=new int[N];
            static int idx=0;

            static int n;   // 不仅代表点的个数还代表点的编号
            public static void main(String[] args) throws IOException{
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//                String[] str1 = reader.readLine().split(" ");
                Scanner scanner=new Scanner(System.in);
                n = scanner.nextInt();
                int m = scanner.nextInt();
                Arrays.fill(h, -1);
                while(m -- > 0)
                {
//                    String[] str2 = reader.readLine().split(" ");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    int c = scanner.nextInt();
                    add(a,b,c);
                }
                System.out.println(dijkstra());
            }
            static void add(int a,int b,int c){
                e[idx]=b;
                w[idx]=c;
                ne[idx]=h[a];
                h[a]=idx++;
            }
            static int dijkstra(){
                Arrays.fill(dist,INF);
                dist[1]=0;
                // 堆始终存储访问过的离源点最近的点
                PriorityQueue<PII> queue=new PriorityQueue<>();
                queue.offer(new PII(0,1));
                while (!queue.isEmpty()){
                    PII top=queue.poll();
                    int distance=top.first;
                    int cur=top.second;
                    if (visited[cur])   // 说明是第二次访问了，每个点只需要访问一遍
                        continue;
                    visited[cur]=true;
                    for (int i = h[cur]; i != -1 ; i=ne[i]) {   // i其实就是每条边了
                        int j=e[i];
                        if (dist[j]>distance+w[i]){
                            dist[j]=distance+w[i];
                            queue.offer(new PII(dist[j],j));
                        }
                    }
                }
                if (dist[n]==INF)
                    return -1;
                return dist[n];
            }
            static class PII implements Comparable<PII>{
                int first;  // 距离
                int second; // 点的编号

                public PII(int first, int second) {
                    this.first = first;
                    this.second = second;
                }

                public int getFirst() {
                    return first;
                }

                public int getSecond() {
                    return second;
                }

                @Override
                public int compareTo(PII o) {
                    return Integer.compare(this.first,o.first); // 按照第一个值从小到大排序
                }
            }
        }
    }
    static class CodeWing2{
        // SPFA
        static int N = 100010;
        static int n;
        static int m;
        static int[] h = new int[N];
        static int[] e = new int[N];
        static int[] ne = new int[N];
        static int[] w = new int[N];
        static int idx = 0;
        static int[] dist = new int[N];
        static boolean[] st = new boolean[N]; //标记是否在队列中
        static int INF = 0x3f3f3f3f;
        public static void add(int a,int b,int c)
        {
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx ++;
        }
        public static int spfa()
        {
            Arrays.fill(dist, INF);
            Queue<Integer> queue = new LinkedList<Integer>();
            dist[1] = 0;
            queue.add(1);
            st[1] = true;//标记1号点在队列中
            while(!queue.isEmpty())
            {
                int t = queue.poll();
                st[t] = false;
                for(int i = h[t];i != -1;i = ne[i])
                {
                    int j = e[i];//获取点编号
                    //若该点被更新过，则加入队列中
                    if(dist[j] > dist[t] + w[i])
                    {
                        dist[j] = dist[t] + w[i];
                        //判断该点是否已经在队列中
                        if(!st[j])
                        {
                            queue.add(j);
                            st[j] = true;//标记已加入队列
                        }
                    }

                }
            }
            return dist[n];
        }
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = reader.readLine().split(" ");
            n = Integer.parseInt(str1[0]);
            m = Integer.parseInt(str1[1]);
            Arrays.fill(h, -1);
            while(m -- > 0)
            {
                String[] str2 = reader.readLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                int c = Integer.parseInt(str2[2]);
                add(a,b,c);
            }
            int t = spfa();
            if(t == 0x3f3f3f3f) System.out.println("impossible");
            else System.out.println(t);

        }
    }
}
