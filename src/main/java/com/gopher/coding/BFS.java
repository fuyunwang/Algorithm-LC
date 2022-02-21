package com.gopher.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022/2/20 22:41
 * @Description: BFS求最短路只适用于边权为1的图
 */
public class BFS {
    static class Code844{
        private static final int N = 110;
        private static int[][] g = new int[N][N], d = new int[N][N];
        private static PII[] q = new PII[N * N];
        private static int n;
        private static int m;

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = reader.readLine().split(" ");
            n = Integer.parseInt(str1[0]);
            m = Integer.parseInt(str1[1]);
            for (int i = 0; i < n; i++) {
                String[] str = reader.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    g[i][j] = Integer.parseInt(str[j]);
                }
            }
            System.out.println(bfs());
            reader.close();
        }

        private static int bfs() {
            int hh = 0, tt = 0;
            q[0] = new PII(0, 0);
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d[i].length; j++) {
                    d[j][i] = -1;
                }
            }
            d[0][0] = 0;
            int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
            while (hh <= tt) {
                PII t = q[hh++];
                for (int i = 0; i < 4; i++) {
                    int x = t.getFirst() + dx[i], y = t.getSecond() + dy[i];
                    if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1) {
                        d[x][y] = d[t.getFirst()][t.getSecond()] + 1;
                        q[++tt] = new PII(x, y);
                    }
                }
            }
            return d[n - 1][m - 1];
        }
    }

    static class PII {
        private int first;
        private int second;
        public PII(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public PII() {
        }
        public int getFirst() {
            return first;
        }
        public int getSecond() {
            return second;
        }
    }

    // 8数码
        // 状态表示。一个是表示，一个是距离，可以分别用queue<String>和Map<String,Integer>来表示
        // 状态转移。状态表示可以看做序列化的结果，采用反序列化后再状态转移
    static class Digit{
        static Map<String, Integer> map = new HashMap<>(); // 记录最小步数

        public static void main(String[] args){
            Scanner cin = new Scanner(System.in);

            String str = "";

            for (int i = 0; i < 9; i ++){
                str += cin.next();
            }

            System.out.print(bfs(str));
        }

        static int bfs(String str){

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            Queue<String> q = new LinkedList<>();
            q.add(str);
            map.put(str, 0);
            while (!q.isEmpty()){
                String t = q.remove();
                if (t.equals("12345678x")) return map.get(t);
                int pos = t.indexOf('x');
                // 注意一位数组对应二位数组索引的变换
                int x = pos / 3;
                int y = pos % 3;
                for (int i = 0; i < 4; i ++){
                    int tx = x + dx[i];
                    int ty = y + dy[i];
                    if (tx < 0 || tx >= 3 || ty < 0 || ty >= 3) continue;
                    String tstr = makeStr(t, pos, tx * 3 + ty);
                    if (map.containsKey(tstr)) continue;
                    map.put(tstr, map.get(t) + 1);
                    q.add(tstr);
                }
            }
            return -1;
        }

        static String makeStr(String t, int originPos, int targetPos){
            StringBuilder str = new StringBuilder(t);
            str.setCharAt(originPos, t.charAt(targetPos));
            str.setCharAt(targetPos, 'x');
            return str.toString();
        }
    }
}
