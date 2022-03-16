package com.gopher.ending.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022/3/13 10:42
 * @Description:
 */
public class BFS {
    static class CodeWing1{
        // 迷宫
        static class Code1{
            static int N=110;
            static int[][] g=new int[N][N]; // 图
            static int[][] dist=new int[N][N]; // 记录每一个点到起点的距离
            static int n,m;
            static Queue<int[]> queue=new LinkedList<>();
            static int[] dx=new int[]{-1,0,1,0};
            static int[] dy=new int[]{0,1,0,-1};
            public static void main(String[] args) throws IOException {
                BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
                String[] str=reader.readLine().trim().split(" ");
                n=Integer.parseInt(str[0]);
                m=Integer.parseInt(str[1]);
                for (int i = 0; i < n; i++) {
                    str=reader.readLine().trim().split(" ");
                    for (int j = 0; j < m; j++) {
                        g[i][j]=Integer.parseInt(str[j]);
                    }
                }
                System.out.println(bfs());
            }
            static int bfs(){
                for (int i = 0; i < n; i++) {
                    Arrays.fill(dist[i],-1);
                }
                dist[0][0]=0;
                queue.offer(new int[]{0,0});
                while (!queue.isEmpty()){
                    int[] top=queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int a=top[0]+dx[i];
                        int b=top[1]+dy[i];
                        if (a<0||a>=n||b<0||b>=m||dist[a][b]!=-1||g[a][b]!=0)
                            continue;
                        queue.offer(new int[]{a,b});
                        dist[a][b]=dist[top[0]][top[1]]+1;
                    }
                }
                return dist[n-1][m-1];
            }
        }
        // 八数码
        static class Code2{
            static Map<String,Integer> dist=new HashMap<>();
            static int[] dx=new int[]{1,0,-1,0};
            static int[] dy=new int[]{0,1,0,-1};
            public static void main(String[] args) {
                Scanner scanner=new Scanner(System.in);
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    sb.append(scanner.next());
                }
                System.out.println(bfs(sb.toString()));
            }
            static int bfs(String src){
                dist.put(src,0);
                Queue<String> queue=new LinkedList<>();
                queue.offer(src);
                while (!queue.isEmpty()){
                    String top=queue.poll();
                    if (top.equals("12345678x"))
                        return dist.get(top);
                    int pos=top.indexOf('x');
                    int x=pos/3;
                    int y=pos%3;
                    for (int i = 0; i < 4; i++) {
                        int a=x+dx[i];
                        int b=y+dy[i];
                        if (a<0||a>=3||b<0||b>=3) continue;
                        String newStr=makeStr(top,pos,a*3+b);
                        if (dist.containsKey(newStr))   // 避免重复搜索
                            continue;
                        dist.put(newStr,dist.get(top)+1);
                        queue.offer(newStr);
                    }
                }
                return -1;
            }
            static String makeStr(String t,int src,int dest){
                StringBuilder stringBuilder=new StringBuilder(t);
                stringBuilder.setCharAt(src,t.charAt(dest));
                stringBuilder.setCharAt(dest,'x');  // 目标位置和原始位置的字符互换
                return stringBuilder.toString();
            }
        }
    }


    static class Code864{
        // 类似双端队列求 AcWing1131
    }
    static class Code815{
        // 公交路线，一类题型，多个环相交求经过几个环
        // 多源多汇
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) return 0;
            int n = routes.length;
            Map<Integer, List<Integer>> map = new HashMap();// 每个站点会挂载哪些环线
            int[] dist = new int[n];
            Arrays.fill(dist, 1000000);
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++){//遍历所有路线
                for (int x:routes[i]){
                    if (x == source){
                        dist[i] = 1;
                        queue.add(i);
                    }
                    if (map.get(x) == null){
                        map.put(x, new ArrayList<>());
                    }
                    map.get(x).add(i);
                }
            }
            while (!queue.isEmpty()){
                int t = queue.poll();
                for (int x:routes[t]){
                    if (x == target) return dist[t];
                    if (map.get(x) != null){
                        for (int y:map.get(x)){
                            if (dist[y] > dist[t] + 1){
                                dist[y] = dist[t] + 1;
                                queue.add(y);
                            }
                        }
                        map.remove(x);
                    }
                }
            }
            return -1;
        }
    }
}
