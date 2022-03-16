package com.gopher.ending.graph;

import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Title Topological
 * @Author fyw
 * @Date 2022-03-14 10:04
 * @Description
 */
public class Topological {
    static class CodeWing1{
        static int N=100010;
        // 记录构图信息
        static int[] h=new int[N];
        static int[] e=new int[N];
        static int[] ne=new int[N];
        static int idx=0;
        // 记录入度信息
        static int[] degree=new int[N];
        // 记录拓扑排序的信息
        static int[] res=new int[N];
        static int cnt=0;
        // 存一下图的节点信息
        static int n;
        public static void main(String[] args) {
            // 构图
            Scanner scanner=new Scanner(System.in);
            n=scanner.nextInt();
            int m=scanner.nextInt();
            Arrays.fill(h,-1);
            for (int i = 0; i < m; i++) {
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                add(a,b);
                degree[b]++;
            }
            if (topic()) System.out.println(-1);
            else {
                for (int i = 0; i < n; i++) System.out.print(res[i] + " ");
            }
            scanner.close();
        }
        static void add(int a,int b){
            e[idx]=b;
            ne[idx]=h[a];
            h[a]=idx++;
        }
        static boolean topic(){
            Queue<Integer> queue=new LinkedList<>();
            // 节点信息遍历，如果是入度为0加入队列
            for (int i = 1; i <= n; i++) {
                if (degree[i]==0){
                    queue.offer(i);
                }
            }
            // 进行拓扑排序
            while (!queue.isEmpty()){
                int top=queue.poll();
                res[cnt++]=top;
                for (int i = h[top]; i != -1 ; i=ne[i]) {
                    int j=e[i];
                    degree[j]--;
                    if (degree[j]==0){
                        queue.offer(j);
                    }
                }
            }
            return cnt<n;
        }
    }
}
