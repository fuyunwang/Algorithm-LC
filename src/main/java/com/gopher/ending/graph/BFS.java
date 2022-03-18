package com.gopher.ending.graph;

import java.io.*;
import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022/3/13 10:42
 * @Description:
 */
public class BFS {
    static class CodeWing1 {
        // 迷宫
        static class Code1 {
            static int N = 110;
            static int[][] g = new int[N][N]; // 图
            static int[][] dist = new int[N][N]; // 记录每一个点到起点的距离
            static int n, m;
            static Queue<int[]> queue = new LinkedList<>();
            static int[] dx = new int[]{-1, 0, 1, 0};
            static int[] dy = new int[]{0, 1, 0, -1};

            public static void main(String[] args) throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String[] str = reader.readLine().trim().split(" ");
                n = Integer.parseInt(str[0]);
                m = Integer.parseInt(str[1]);
                for (int i = 0; i < n; i++) {
                    str = reader.readLine().trim().split(" ");
                    for (int j = 0; j < m; j++) {
                        g[i][j] = Integer.parseInt(str[j]);
                    }
                }
                System.out.println(bfs());
            }

            static int bfs() {
                for (int i = 0; i < n; i++) {
                    Arrays.fill(dist[i], -1);
                }
                dist[0][0] = 0;
                queue.offer(new int[]{0, 0});
                while (!queue.isEmpty()) {
                    int[] top = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int a = top[0] + dx[i];
                        int b = top[1] + dy[i];
                        if (a < 0 || a >= n || b < 0 || b >= m || dist[a][b] != -1 || g[a][b] != 0)
                            continue;
                        queue.offer(new int[]{a, b});
                        dist[a][b] = dist[top[0]][top[1]] + 1;
                    }
                }
                return dist[n - 1][m - 1];
            }
        }

        // 八数码
        static class Code2 {
            static Map<String, Integer> dist = new HashMap<>();
            static int[] dx = new int[]{1, 0, -1, 0};
            static int[] dy = new int[]{0, 1, 0, -1};

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    sb.append(scanner.next());
                }
                System.out.println(bfs(sb.toString()));
            }

            static int bfs(String src) {
                dist.put(src, 0);
                Queue<String> queue = new LinkedList<>();
                queue.offer(src);
                while (!queue.isEmpty()) {
                    String top = queue.poll();
                    if (top.equals("12345678x"))
                        return dist.get(top);
                    int pos = top.indexOf('x');
                    int x = pos / 3;
                    int y = pos % 3;
                    for (int i = 0; i < 4; i++) {
                        int a = x + dx[i];
                        int b = y + dy[i];
                        if (a < 0 || a >= 3 || b < 0 || b >= 3) continue;
                        String newStr = makeStr(top, pos, a * 3 + b);
                        if (dist.containsKey(newStr))   // 避免重复搜索
                            continue;
                        dist.put(newStr, dist.get(top) + 1);
                        queue.offer(newStr);
                    }
                }
                return -1;
            }

            static String makeStr(String t, int src, int dest) {
                StringBuilder stringBuilder = new StringBuilder(t);
                stringBuilder.setCharAt(src, t.charAt(dest));
                stringBuilder.setCharAt(dest, 'x');  // 目标位置和原始位置的字符互换
                return stringBuilder.toString();
            }
        }
    }

    static class CodeWing2 {
        // 城堡问题，注意边界判断
        static int N = 60, M = N * N;
        static boolean[][] visited = new boolean[N][N];
        static int[][] g = new int[N][N];
        static int[] dx = new int[]{0, -1, 0, 1};
        static int[] dy = new int[]{-1, 0, 1, 0};
        static int n, m;

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = reader.readLine().trim().split(" ");
            n = Integer.parseInt(str1[0]);
            m = Integer.parseInt(str1[1]);
            for (int i = 0; i < n; i++) {
                String[] str2 = reader.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    g[i][j] = Integer.parseInt(str2[j]);
                }
            }
            // 进行广搜，得到连通块的数量和最大连通块的大小
            int res = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j])
                        continue;
                    res = Math.max(res, bfs(i, j));
                    ans++;
                }
            }
            System.out.println(ans);
            System.out.println(res);
        }

        static int bfs(int i, int j) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, j});
            visited[i][j] = true;
            int cnt = 0; // 用于统计连通块的个数
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                cnt++;
                for (int k = 0; k < 4; k++) {
                    if ((g[now[0]][now[1]] >> k & 1) == 1) continue;
                    int x = now[0] + dx[k];
                    int y = now[1] + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    if (visited[x][y]) continue;
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            return cnt;
        }
    }

    static class CodeWing3 {
        // 抓住那头牛
        static int N = 100010;
        static int n;// 记录农夫的位置
        static int k;// 标记牛的位置
        static int[] dist = new int[N];   // 标记农夫走到每一个位置的具体步数

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            k = scanner.nextInt();
            Arrays.fill(dist, -1);   // 初始赋值，dist后续既可以存储结果，又可以标记是否走过，始终维持最小值
            System.out.println(bfs());
        }

        static int bfs() {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(n);
            dist[n] = 0;

            while (!queue.isEmpty()) {
                int t = queue.poll();
                if (t - 1 >= 0 && dist[t - 1] == -1) {
                    dist[t - 1] = dist[t] + 1;
                    if (t - 1 == k) {
                        return dist[t - 1];
                    }
                    queue.offer(t - 1);
                }
                if (t + 1 < N && dist[t + 1] == -1) {
                    dist[t + 1] = dist[t] + 1;
                    if (t + 1 == k) {
                        return dist[t + 1];
                    }
                    queue.offer(t + 1);
                }
                if (2 * t < N && dist[2 * t] == -1) {
                    dist[2 * t] = dist[t] + 1;
                    if (2 * t == k) {
                        return dist[2 * t];
                    }
                    queue.offer(2 * t);
                }
            }
            return 0;
        }
    }

    static class CodeWing4 {    // 经典BFS
        static final int N = 200;
        static char[][] g = new char[N][N]; //存储地图
        static int[][] dist = new int[N][N]; //dist表示距离起点的距离，同时做判重
        static int n, m; //行，列
        static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}, dy = {1, 2, 2, 1, -1, -2, -2, -1}; //走日的八个方向
        static PII start = null, end = null; //起点，终点
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static int bfs() {
            Queue<PII> queue = new LinkedList<PII>(); //创建队列
            queue.offer(start); //起点加入队列
            for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1); //都初始化为-1
            dist[start.x][start.y] = 0; //起点距离设为0，表示遍历过
            while (!queue.isEmpty()) //当队列非空
            {
                PII t = queue.poll(); //取出队头元素，并删除
                for (int i = 0; i < 8; i++) //遍历八个方向
                {
                    int a = t.x + dx[i], b = t.y + dy[i];
                    if (a < 0 || a >= n || b < 0 || b >= m) continue; //越界
                    if (dist[a][b] != -1) continue; //遍历过，跳过
                    if (g[a][b] == '*') continue; //障碍物，跳过

                    //否则
                    dist[a][b] = dist[t.x][t.y] + 1;
                    if (a == end.x && b == end.y) return dist[a][b]; //如果已经到终点，直接返回
                    queue.offer(new PII(a, b)); //加入队列
                }
            }
            return -1; //没有则返回-1，但此题保证一定有解
        }
        public static void main(String[] args) throws IOException {
            String s[] = br.readLine().split(" ");
            m = Integer.parseInt(s[0]); //注意此题先读列数再读行数
            n = Integer.parseInt(s[1]);
            for (int i = 0; i < n; i++) {
                g[i] = br.readLine().toCharArray(); //读取一行，字符串传化为字符数组
                for (int j = 0; j < m; j++) {
                    if (g[i][j] == 'K') //起点
                        start = new PII(i, j);
                    else if (g[i][j] == 'H') //终点
                        end = new PII(i, j);
                }
            }
            int res = bfs();
            System.out.println(res);
        }
        static class PII {
            int x;
            int y;
            public PII(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

    }

    static class CodeWing5{
        // 矩阵距离，逆向思维，转化成多源最短路问题，从矩阵中值为1的点开始宽搜
        static int N = 1010;
        static int n ;
        static int m ;
        static char[][] g = new char[N][N];
        static int[][] dist = new int[N][N];
        static int[] dx = new int[] {-1,0,1,0};
        static int[] dy = new int[] {0,1,0,-1};
        static void bfs()
        {
            Queue<PIIs> q = new LinkedList<PIIs>();
            for(int i = 0;i < n;i ++) Arrays.fill(dist[i], -1);
            for(int i = 0;i < n;i ++)
                for(int j = 0;j < m;j ++)
                {
                    if(g[i][j] == '1')
                    {
                        dist[i][j] = 0;
                        q.add(new PIIs(i,j));
                    }
                }
            while(!q.isEmpty())
            {
                PIIs t = q.poll();
                for(int i = 0;i < 4;i ++)
                {
                    int a = t.x + dx[i];
                    int b = t.y + dy[i];
                    if(a < 0 || a >= n || b < 0 || b >= m) continue;
                    if(dist[a][b] != -1) continue;
                    dist[a][b] = dist[t.x][t.y] + 1;
                    q.add(new PIIs(a,b));
                }
            }
        }
        public static void main(String[] args) throws IOException {
            Scanner scan = new Scanner(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            n = scan.nextInt();
            m = scan.nextInt();
            for(int i = 0;i < n;i ++)
            {
                char[] charArray = scan.next().toCharArray();
                for(int j = 0;j < m;j ++)
                {
                    g[i][j] = charArray[j];
                }
            }
            bfs();
            for(int i = 0;i < n;i ++)
            {
                for(int j = 0;j < m;j ++)
                {
                    out.write(dist[i][j] + " ");
                }
                out.write("\n");
            }
            out.flush();
        }

    static class PIIs
    {
        public int x;
        public int y;
        public PIIs(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    }

    static class Code864 {
        // 类似双端队列求 AcWing1131
    }

    static class Code815 {
        // 公交路线，一类题型，多个环相交求经过几个环
        // 多源多汇
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) return 0;
            int n = routes.length;
            Map<Integer, List<Integer>> map = new HashMap();// 每个站点会挂载哪些环线
            int[] dist = new int[n];
            Arrays.fill(dist, 1000000);
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {//遍历所有路线
                for (int x : routes[i]) {
                    if (x == source) {
                        dist[i] = 1;
                        queue.add(i);
                    }
                    if (map.get(x) == null) {
                        map.put(x, new ArrayList<>());
                    }
                    map.get(x).add(i);
                }
            }
            while (!queue.isEmpty()) {
                int t = queue.poll();
                for (int x : routes[t]) {
                    if (x == target) return dist[t];
                    if (map.get(x) != null) {
                        for (int y : map.get(x)) {
                            if (dist[y] > dist[t] + 1) {
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
