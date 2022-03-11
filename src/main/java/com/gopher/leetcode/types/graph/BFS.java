package com.gopher.leetcode.types.graph;

import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022-03-03 9:55
 * @Description
 */
public class BFS {
    static class Code773{
        /**
         * 8数码问题变形
         * @param board
         * @return
         */
        public int slidingPuzzle(int[][] board) {
            int [][] target = new int[][]{{1,2,3},{4,5,0}};
            if (changeToStr(board).equals(changeToStr(target))) return 0;
            Queue<int[][]> q = new LinkedList<>();
            q.add(board);
            Map<String, Integer> dist = new HashMap<>();
            dist.put(changeToStr(board), 0);
            int direc[][] = new int[][]{{1,0},{-1, 0},{0, 1},{0, -1}};
            while (!q.isEmpty()){
                int[][] t = q.poll();
                int x = 0, y = 0;//'0' 的位置
                for (int i = 0; i < 2; i++){
                    for (int j = 0; j < 3; j++){
                        if (t[i][j] == 0){
                            x = i; y = j;
                        }
                    }
                }
                for (int i = 0 ; i < 4; i++){
                    int a = x + direc[i][0];
                    int b = y + direc[i][1];
                    if (a >= 0 && a < 2 && b >= 0 && b < 3){
                        int[][] r = copy(t);
                        int temp = r[x][y];
                        r[x][y] = r[a][b];
                        r[a][b] = temp;
                        if (dist.getOrDefault(changeToStr(r), 0) == 0){
                            dist.put(changeToStr(r), dist.getOrDefault(changeToStr(t), 0) + 1);
                            if (changeToStr(r).equals(changeToStr(target))) return dist.get(changeToStr(r));
                            q.add(r);
                        }
                    }
                }
            }
            return -1;
        }

        int[][] copy (int[][] target){
            int[][] b = new int[target.length][target[0].length];
            for (int i = 0; i < target.length; i++){
                for (int j = 0; j < target[0].length; j++){
                    b[i][j] = target[i][j];
                }
            }
            return b;
        }

        String changeToStr(int[][] board){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                    sb.append(board[i][j]);
                }
            }
            return sb.toString();
        }

    }
    static class Code1091{
        // 二进制矩阵中的最短路径，迷宫问题
        public static int shortestPathBinaryMatrix(int[][] grid) {
            if (grid==null||grid.length==0||grid[0].length==0)
                return -1;
            int n=grid.length;
            if (grid[0][0]!=0||grid[n-1][n-1]!=0)
                return -1;

            int[][] step=new int[n][n];
            for (int i = 0; i < step.length; i++) {
                Arrays.fill(step[i],-1);
            }
            step[0][0]=1;
            Queue<int[]> queue=new LinkedList<>();
            queue.offer(new int[]{0,0});
            int[] dx=new int[]{-1,0,1,-1,1,-1,0,1};
            int[] dy=new int[]{-1,-1,-1,0,0,1,1,1};

            while (!queue.isEmpty()){
                int[] poll = queue.poll();
                int x=poll[0];
                int y=poll[1];
                if (x==n-1&&y==n-1)
                    return step[x][y];
                for (int d=0;d<8;d++){
                    int a=x+dx[d];
                    int b=y+dy[d];
                    if (a>=n||a<0||b>=n||b<0||grid[a][b]!=0||step[a][b]!=-1)
                        continue;
                    queue.offer(new int[]{a,b});
                    step[a][b]=step[x][y]+1;
                }
            }
            return -1;
        }

        static class Pair{
            int x;
            int y;
            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this==o)
                    return true;
                if (o==null)
                    return false;
                if (o instanceof Pair){
                    Pair oPair= (Pair) o;
                    return oPair.x==this.x&&oPair.y==this.y;
                }
                return false;
            }

            @Override
            public int hashCode() {
                int result=17;
                result=31*result+x;
                result=31*result+y;
                return result;
            }
        }

        public static void main(String[] args) {
            int[][] g=new int[][]{{0,0,0},{1,1,0},{1,1,0}};
            shortestPathBinaryMatrix(g);
        }
    }

    static class Code934{
        // 多源BFS
        int n;
        int m;
        int[][] a;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        LinkedList<List<Integer>> q = new LinkedList<>();
        Map<List<Integer>, Integer> dist = new HashMap<>();

        public int shortestBridge(int[][] grid) {
            // 1、多源bfs求最短路问题，a岛可以看作源，b岛看作目的，从a岛中可以有多个点到达b岛，这类问题可以将a中所有点(x,y)先加到队列中（dfs）。
            // 2、然后出队，并更新dist值(取最小的)，直到到达b岛中任一一个节点，返回最短的路径即可（变换的0的数目为dist - 1）。
            // 3 dist使用map, key:坐标list, value到该坐标的距离。
            n = grid.length;
            m = grid[0].length;
            a = grid;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        dfs(i, j);
                        return bfs();
                    }
                }
            }
            return -1;
        }
        void dfs(int x, int y) {
            a[x][y] = 0;
            q.offer(Arrays.asList(x, y));
            dist.put(Arrays.asList(x, y), 0);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && a[nx][ny] == 1) dfs(nx, ny);
            }
        }
        int bfs() {
            while (q.size() > 0) {
                List<Integer> list = q.poll();
                int x = list.get(0);
                int y = list.get(1);
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !dist.containsKey(Arrays.asList(nx, ny))) {
                        dist.put(Arrays.asList(nx, ny), dist.get(list) + 1);
                        q.offer(Arrays.asList(nx, ny));
                        if (a[nx][ny] == 1) return dist.get(Arrays.asList(nx, ny)) - 1;
                    }
                }
            }
            return -1;
        }

    }
}
