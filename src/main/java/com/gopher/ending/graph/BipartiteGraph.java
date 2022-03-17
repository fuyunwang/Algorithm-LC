package com.gopher.ending.graph;
import java.util.*;
import java.io.*;

/**
 * @Title BipartiteGraph
 * @Author fyw
 * @Date 2022-03-17 10:23
 * @Description 二分图
 */
public class BipartiteGraph {
    static class CodeWing1{
        // 染色法判断二分图
        static int N=100010,M=2*N;
        static int n,m;
        static int[] h=new int[N];
        static int[] e=new int[N];
        static int[] ne=new int[N];
        static int idx=0;
        static boolean[] visited=new boolean[N];
        static int[] color=new int[N];
        static void add(int a,int b){
            e[idx]=b;
            ne[idx]=h[a];
            h[a]=idx++;
        }
        public static void main(String[] args) throws IOException{
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
                add(a,b);
                add(b,a);
            }
            boolean flag=false;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]){
                    if (!dfs(i,1)){
                        flag=true;
                        break;
                    }
                }
            }
            if (flag){
                // 说明不能染色
            }
        }
        // 只能染成一和2两种颜色，传入当前点和颜色
        static boolean dfs(int u,int c){
            color[u]=c;
            visited[u]=true;
            for (int i = h[u]; i !=-1 ; i=ne[i]) {
                int j=e[i];
                if (!visited[j]){
                    if (!dfs(j,3-c))
                        return false;
                }else{
                    if (color[j]==c){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    static class CodeWing2{
        // 二分图的最大匹配
    }
}
