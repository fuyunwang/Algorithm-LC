package com.gopher.hardcoding.graph;
import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022/2/26 21:42
 * @Description:
 */
public class BFS {
    static class Code1{
        // 迷宫问题输出路径，路径即所有包含的点
        static int n,m,N=1010;
        static int [][] g=new int[N][N];
        static int [][][] path=new int[N][N][2];
        static boolean [][] st=new boolean[N][N];
        public static void bfs(){
            LinkedList<int[]> ls=new LinkedList<>();
            ls.addLast(new int[]{n-1,n-1});
            int[] dirx={-1,0,1,0},diry={0,1,0,-1};
            while(!ls.isEmpty()){
                int [] t=ls.pollFirst();
                for(int i=0;i<4;i++){
                    int x=t[0]+dirx[i],y=t[1]+diry[i];
                    if(x<0||y<0||x>=n||y>=n) continue;
                    if(st[x][y]||g[x][y]==1) continue;
                    st[x][y]=true;
                    ls.addLast(new int[]{x,y});
                    path[x][y]=t;
                }
            }
        }
        public static void main(String [] args){
            Scanner sc=new  Scanner(System.in);
            n=sc.nextInt();
            for(int i =0;i<n;i++){
                for(int j=0;j<n;j++){
                    g[i][j]=sc.nextInt();
                }
            }
            bfs();
            int[] t=new int[]{0,0};
            while(true){
                System.out.println(t[0]+" "+t[1]);
                if(t[0]==n-1&&t[1]==n-1) break;
                t=path[t[0]][t[1]];
            }
        }
    }
}
