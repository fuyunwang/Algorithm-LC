//package com.gopher.leetcode.order.or700;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
///**
// * @Title Code749
// * @Author fyw
// * @Date 2022/2/14 16:39
// * @Description: 隔离病毒
// */
//public class Code749 {
//    int m,n;
//    int[][] grid;
//    boolean[][] visited;
//    List<Pair> tempPath=new ArrayList<>(); // 遍历过的点，就是已经被感染的
//    HashSet<Pair> tempSet=new HashSet<>(); // 当前影响到的点，就是明天会被感染的
//    public int containVirus(int[][] isInfected) {
//        this.grid=isInfected;
//        this.m=isInfected.length;
//        this.n=isInfected[0].length;
//        int res=0;
//        for (;;){
//            final int i = find();
//            if (i==0)
//                break;
//            res+=i;
//        }
//        return res;
//    }
//    // find 返回dfs的结果，即当前要建隔板的数目
//    int find(){
//        this.visited=new boolean[m][n];
//        int res=0;
//        int count=0;
//        List<Pair> path=new ArrayList<>(); // 遍历过的点
//        List<HashSet<Pair>> futurePath=new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!visited[i][j]&&grid[i][j]==1){
//                    // 如果没有访问过并且当前位置为病源
//                    tempPath.clear();
//                    tempSet.clear();
//                    final int dfs = dfs(i, j);
//                    if (tempSet.size()>count){  // 看哪一次可能明天感染的最多
//                        count=tempSet.size();
//                        res=dfs;                // 要建的隔板的熟练要根据可能明天感染的最多的今天病毒来定，隔板一天只会建一次
//                        path=tempPath;
//                    }
//                    futurePath.add(tempSet);        // 但是只要未建隔板的每天都会持续感染
//                }
//            }
//        }
//        // 对于要建的隔板位置进行标记
//        for (Pair d:path){
//            grid[d.x][d.y]=-1;
//        }
//        // 对于即将感染的位置，进行感染因为目前还来不及建隔板
//        for (HashSet<Pair> set:futurePath){
//            if (set.size()!=count){
//                for (Pair d:set){
//                    grid[d.x][d.y]=1;
//                }
//            }
//        }
//        return res;
//    }
//    // 进行dfs,dfs返回要建的墙的数量
//    int[] dx=new int[]{-1,0,1,0};
//    int[] dy=new int[]{0,1,0,-1};
//    int dfs(int x,int y){
//        visited[x][y]=true;
//        Pair pair=new Pair();
//        pair.x=x;
//        pair.y=y;
//        tempPath.add(pair);
//        int res=0;
//        for (int i = 0; i < 4; i++) {
//            int a=x+dx[i];
//            int b=y+dy[i];
//            if (a<0||a>=m||b<0||b>=n){
//                continue;
//            }
//            if (grid[a][b]==0){
//                // 如果即将枚举的是0，不管是否访问过都应该会被感染且应该增加隔板
//                Pair pair1=new Pair();
//                pair1.x=a;
//                pair1.y=b;
//                tempSet.add(pair1);
//                res++;
//            }else if (grid[a][b]==1&&!visited[a][b]){
//                //如果未访问过是被感染的区域则递归查找后续
//                res+=dfs(a,b);
//            }
//        }
//        return res;
//    }
//    class Pair{
//        public int x;
//        public int y;
//
//        @Override
//        public int hashCode() {
//            int result=17;
//            result=31*result+x;
//            result=31*result+y;
//            return result;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this==obj){
//                return true;
//            }
//            if (obj==null)
//                return false;
//            if (obj instanceof Pair){
//                Pair p= (Pair) obj;
//                if (this.x==p.x&&this.y==p.y){
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//}
