package com.gopher.hardcoding.graph;
import java.io.IOException;
import java.util.*;

/**
 * @Title BFS
 * @Author fyw
 * @Date 2022/2/26 21:42
 * @Description: 考虑路径的收集、双端队列广搜、双向广搜
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

    static class Code2{
        // 抓住那头牛
        static int n,m;// 分别表示人的位置和牛的位置
        public static void main(String[] args) throws IOException {
            bfs(n, m);
        }

        private static void bfs(int n, int m) {
            int[] step = new int[Math.max(n + 1, m * 2)];

            LinkedList<Point> q = new LinkedList<>();
            q.add(new Point(n, 1));

            while (!q.isEmpty()) {
                Point p = q.poll();

                if (step[p.val] == 0) {
                    step[p.val] = p.step;

                    if (p.val == m) {
                        System.out.println(p.step-1);       /// 最优步数
                        return;
                    }

                    if (p.val < m)
                        q.add(new Point(p.val * 2, p.step + 1));

                    if (p.val < m)
                        q.add(new Point(p.val + 1, p.step + 1));

                    if (p.val > 0)
                        q.add(new Point(p.val - 1, p.step + 1));
                }
            }

        }

        public static class Point {
            int val;
            int step;

            public Point(int val, int step) {
                this.val = val;
                this.step = step;
            }
        }
    }

    static class Code3{
            // 魔板 注意路径的保存 pre
            static char[][] g = new char[2][4];
            static Queue<String> q = new LinkedList<>();
            static HashMap<String, Integer> dist = new HashMap<>();
            static HashMap<String, node> pre = new HashMap<>();
            static String[] store = {"A", "B", "C"};

            public static void main(String[] args){
                String end = "", start = "";

                Scanner cin = new Scanner(System.in);
                for(int i = 0; i < 8; i ++){
                    end += cin.next();
                    start += (char)(i + '1');
                }

                bfs(start, end);

                System.out.println(dist.get(end));
                String str = "";
                String ss = end;
                while (!pre.get(ss).id.equals("D")){
                    str += pre.get(ss).id;
                    ss = pre.get(ss).st;
                }
                for (int i = str.length()-1; i >= 0 ; i --){
                    System.out.print(str.charAt(i));
                }
            }

            static void bfs(String start, String end){
                q.offer(start);
                dist.put(start, 0);
                pre.put(start, new node(start, "D"));
                while(!q.isEmpty()){
                    String t = q.poll();

                    String[] m = new String[3];

                    m[0] = moveA(t);
                    m[1] = moveB(t);
                    m[2] = moveC(t);

                    for (int i = 0; i < 3; i ++){
                        if(dist.containsKey(m[i])) continue;
                        q.offer(m[i]);
                        dist.put(m[i], dist.get(t) + 1);
                        pre.put(m[i], new node(t, store[i])); // st id
                        if(m[i].equals(end)){
                            break;
                        }
                    }
                }
            }

            static String moveA(String t){
                set(t);
                char temp;
                for(int i = 0; i < 4; i ++){
                    temp = g[0][i];
                    g[0][i] = g[1][i];
                    g[1][i] = temp;
                }
                return get();
            }
            static String moveB(String t){
                set(t);
                char t1 = g[0][3];
                char t2 = g[1][3];
                for (int i = 3; i > 0; i --){
                    g[0][i] = g[0][i-1];
                    g[1][i] = g[1][i-1];
                }
                g[0][0] = t1;
                g[1][0] = t2;
                return get();
            }
            static String moveC(String t){
                set(t);
                char t1 = g[0][1];
                char t2 = g[0][2];
                char t3 = g[1][1];
                char t4 = g[1][2];

                g[0][1] = t3;
                g[0][2] = t1;
                g[1][1] = t4;
                g[1][2] = t2;
                return get();
            }

            static void set(String t){
                for (int i = 0; i < 4; i ++){
                    g[0][i] = t.charAt(i);
                }
                int j = 3;
                for (int i = 4; i < 8; i ++){
                    g[1][j--] = t.charAt(i);
                }
            }

            static String get(){
                String s = "";
                for (int i = 0; i < 4; i ++){
                    s += g[0][i];
                }
                for (int i = 3; i >= 0; i --){
                    s += g[1][i];
                }
                return s;
            }
        static class node{
            node(String st, String id){
                this.st = st;
                this.id = id;
            }
            String st;
            String id;
        }
    }

    static class Code4{
        // 双端队列广搜， 双端队列主要解决图中边的权值只有0或者1的最短路问题
        // 注意数据，输入三行但是边界多1，即边界点是4，而我们要处理的也是边界只是同时考虑格子
        static char[] cs = new char[] {'\\', '/', '\\', '/'};//'/'需要转义
        static int[] dx = new int[]{-1, -1, 1, 1};
        static int[] dy = new int[]{-1, 1, 1, -1};
        static int[] ix = new int[]{-1, -1, 0, 0};
        static int[] iy = new int[]{-1, 0, 0, -1};
        static int N = 501, INF = 0x3f3f3f3f;
        static int n, m;
        static char[][] g = new char[N][N];
        static boolean[][] st = new boolean[N][N];
        static int[][] dist = new int[N][N];
        static int bfs()
        {
            for(int i = 0;i <= n;i ++) Arrays.fill(st[i], false);
            for(int i = 0;i <= n;i ++) Arrays.fill(dist[i], INF);
            dist[0][0] = 0;
            Deque<PII> q = new LinkedList<PII>();
            q.addLast(new PII(0, 0));
            while(!q.isEmpty())
            {
                PII t = q.pollFirst();
                int x = t.x, y = t.y;
                if (x == n && y == m) return dist[x][y] ;
                if(st[x][y]) continue;
                st[x][y] = true;

                for(int i = 0;i < 4;i ++)
                {
                    int a = x + dx[i], b = y + dy[i];
                    if(a < 0 || a > n || b < 0 || b > m) continue;
                    int ga = x + ix[i], gb = y + iy[i];
                    int w = g[ga][gb] == cs[i] ? 0 : 1;//观察是否需要转动，若处于理想状态则权值是0，否则需要旋转1次权值是1
                    int d = dist[x][y] + w;
                    if(d < dist[a][b])
                    {
                        dist[a][b] = d;
                        if(w == 1) q.addLast(new PII(a, b));
                        else q.addFirst(new PII(a, b));
                    }
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int T = scan.nextInt();
            while(T -- > 0)
            {
                n = scan.nextInt();
                m = scan.nextInt();
                for(int i = 0;i < n;i ++)
                {
                    String s = scan.next();
                    for(int j = 0;j < m;j ++)
                        g[i][j] = s.charAt(j);
                }

                //n + m不是偶数表示无解
                if(((n + m) & 1) != 0) System.out.println("NO SOLUTION");
                else System.out.println(bfs());
            }
        }

        static class PII
        {
            int x, y;
            PII(int x, int y)
            {
                this.x = x;
                this.y = y;
            }
        }


    }

    static class Code5{
        // 双向广搜
        static int N = 6;
        static int n = 0;
        static String[] a = new String[N];
        static String[] b = new String[N];

        static int extend(Queue<String> q,Map<String,Integer> da,Map<String,Integer> db,String[] a,String[] b)
        {
            String t = q.poll();
            for(int i = 0;i < t.length();i ++)
            {
                for(int j = 0;j < n;j ++)
                {
                    //判断是否越界
                    if(i + a[j].length() > t.length()) continue;
                    if(t.substring(i, i + a[j].length()).equals(a[j]))
                    {
                        String state = t.substring(0,i) + b[j] + t.substring(i + a[j].length());
                        if(da.containsKey(state)) continue;
                        da.put(state, da.get(t) + 1);
                        if(db.containsKey(state)) return da.get(state) + db.get(state) ;
                        q.add(state);
                    }
                }
            }
            return 11;
        }
        static int bfs(String A,String B)
        {
            Queue<String> qa = new LinkedList<String>();
            Queue<String> qb = new LinkedList<String>();
            Map<String,Integer> da = new HashMap<String,Integer>();
            Map<String,Integer> db = new HashMap<String,Integer>();
            qa.add(A);   da.put(A, 0);
            qb.add(B);   db.put(B, 0);

            while(!qa.isEmpty() && !qb.isEmpty())
            {
                int t = 0;
                if(qa.size() <= qb.size()) t = extend(qa,da,db,a,b);
                else t = extend(qb,db,da,b,a);
                if(t <= 10) return t;
            }
            return 11;
        }
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String A = scan.next();
            String B = scan.next();
            while(scan.hasNext())
            {
                a[n] = scan.next();
                b[n] = scan.next();
                n ++;
            }
            int step = bfs(A,B);
            if(step > 10) System.out.println("NO ANSWER!");
            else System.out.println(step);
        }

    }
}
