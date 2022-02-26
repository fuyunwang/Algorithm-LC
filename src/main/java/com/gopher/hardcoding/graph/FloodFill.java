package com.gopher.hardcoding.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @Title FloodFill
 * @Author fyw
 * @Date 2022-02-26 14:55
 * @Description
 */
public class FloodFill {
    // bfs解决池塘计数
    static class Code1{
        class Node{
            int x, y;
            public Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        class Main{
            int N = 1010,n,m;
            char[][] g;
            boolean[][] st;

            void bfs(int x, int y){
                LinkedList<Node> queue=new LinkedList<>();
                queue.addFirst(new Node(x, y));
                while(!queue.isEmpty()){
                    Node node=queue.pollLast();
                    for(int i=node.x-1;i<=node.x+1;i++)
                        for(int j=node.y-1;j<=node.y+1;j++){
                            if(i==node.x&&j==node.y) continue;
                            if(i<0 || i>=n || j<0 || j>=m) continue;
                            if(g[i][j]=='.'||st[i][j]) continue;
                            queue.addFirst(new Node(i,j));
                            st[i][j]=true;
                        }
                }
            }

            public void main(String[] args) throws IOException {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String[] cur = in.readLine().split(" ");

                n = Integer.parseInt(cur[0]);
                m = Integer.parseInt(cur[1]);
                g = new char[n][m];
                st = new boolean[n][m];
                //给数组赋初值
                for(int i=0; i<n; i++){
                    char[] arr = in.readLine().toCharArray();
                    g[i]=arr;
                }

                int res = 0;
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        //如果是空地或者被访问过就直接跳过
                        if(g[i][j] == '.' || st[i][j]) continue;
                        bfs(i, j);
                        res++;
                    }
                }

                System.out.println(res);
            }
        }

    }
}
