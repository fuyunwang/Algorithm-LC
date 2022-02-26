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
        class Node{     // 坐标
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
                st[x][y]=true;
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
                st = new boolean[n][m]; // 标记是否已经访问过
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

    //flood fill  和上一题基本一样，就是题目意思有点不好理解
    //一个格子上的数可以拆分开来，用的是二进制数的和表示的，刚好可以表示四面墙的16种不同的组合方案
    //这个是设计好的，西也就是左边，刚好也是1 ，将x>>1&1就可以看出左边是否有墙，是否能往左走 其他的三个方向也一样
    // 本题要多记录一个面积的最大值，也就是在bfs时要记录一个经过的格子数，然后返回就行，其他和上一题基本一样
    static class Code2{
        // 每个方块中墙的特征由数字 P 来描述，我们用1表示西墙，2表示北墙，4表示东墙，8表示南墙，P 为该方块包含墙的数字之和。
        // 看当前位置某一个方向是否有墙，使用二进制移位的方式
        class Node{
            int i, j;

            public Node(int i, int j){
                this.i = i;
                this.j = j;
            }
        }

        class Main{
            int N = 60, M = N * N;
            int[][] a = new int[N][N];
            Node[] q = new Node[M];
            boolean[][] st = new boolean[N][N];
            int[] dx = {0, -1, 0, 1};
            int[] dy = {-1, 0, 1, 0};
            int n, m;

            int bfs(int i, int j){
                Node cur = new Node(i, j);
                int hh = 0; int tt = -1;
                q[++ tt] = cur;
                st[i][j] = true;

                int cnt = 0; // 用于统计连通块的个数

                while(hh <= tt){
                    Node now = q[hh ++];
                    cnt ++;

                    for(int k=0; k<4; k++){
                        int x = now.i + dx[k];
                        int y = now.j + dy[k];
                        if(x < 0 || x >= n || y < 0 || y >= m) continue;
                        if((a[now.i][now.j] >> k & 1) == 1) continue;
                        if(st[x][y]) continue;
                        st[x][y] = true;
                        q[++ tt] = new Node(x, y);
                    }
                }

                return cnt;
            }

            public void main(String[] args) throws IOException{
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String[] cur = in.readLine().split(" ");
                n = Integer.parseInt(cur[0]);
                m = Integer.parseInt(cur[1]);

                for(int i=0; i<n; i++){
                    String[] arr = in.readLine().split(" ");
                    for(int j=0; j<m; j++){
                        a[i][j] = Integer.parseInt(arr[j]);
                    }
                }

                int res = 0;
                int ans = 0;
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(st[i][j]) continue;
                        res = Math.max(res, bfs(i, j));
                        ans ++;
                    }
                }

                System.out.println(ans);
                System.out.println(res);
            }
        }
    }

    // 山峰和山谷，判断连通块的类型
    
}
