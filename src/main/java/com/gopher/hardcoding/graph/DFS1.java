package com.gopher.hardcoding.graph;
import java.util.*;

/**
 * @Title DFS
 * @Author fyw
 * @Date 2022-02-27 20:05
 * @Description
 */
public class DFS1 {
    static class Code1{
        // 深搜统计数据
        static int N = 25;
        static int m;
        static int n;
        static char[][] g = new char[N][N];
        static boolean[][] st = new boolean[N][N];//记录该点是否遍历过
        static int[] dx = new int[] {-1,0,1,0};
        static int[] dy = new int[] {0,1,0,-1};
        static int dfs(int x,int y)
        {
            int cnt = 1;
            st[x][y] = true;
            for(int i = 0;i < 4;i++)
            {
                int a = x + dx[i];
                int b = y + dy[i];
                if(a < 0 || a >= n || b < 0 || b >= m) continue;
                if(g[a][b] != '.') continue;
                if(st[a][b]) continue;
                cnt += dfs(a,b);
            }
            return cnt;
        }
        public static void main(String[] args)  {
            Scanner scan = new Scanner(System.in);
            while(scan.hasNext())
            {
                m = scan.nextInt();
                n = scan.nextInt();
                if(m == 0 && n == 0) break;
                int x = 0;
                int y = 0;
                for(int i = 0;i < n;i ++)
                {
                    Arrays.fill(st[i], false);
                    char[] charArray = scan.next().toCharArray();
                    for(int j = 0;j < m;j ++)
                    {
                        g[i][j] = charArray[j];
                        if(g[i][j] == '@')
                        {
                            x = i;
                            y = j;
                        }
                    }
                }
                System.out.println(dfs(x,y));
            }

        }
    }

    static class Code2{
        // 马走日 回溯
        static int N = 10;
        static int n;
        static int m;
        static boolean[][] st = new boolean[N][N];//标识该坐标是否走过
        static int[] dx = new int[] {-2,-1,1,2,2,1,-1,-2};
        static int[] dy = new int[] {1,2,2,1,-1,-2,-2,-1};
        static int res = 0;
        static void dfs(int x,int y,int cnt)
        {
            if(cnt == n * m)
            {
                res ++;
                return;
            }

            for(int i = 0;i < 8;i ++)
            {
                int a = x + dx[i];
                int b = y + dy[i];
                if(a < 0 || a >= n || b < 0 || b >= m) continue;
                if(st[a][b]) continue;
                st[a][b] = true;
                cnt ++;
                dfs(a,b,cnt);
                cnt --; //恢复现场
                st[a][b] = false;  //恢复现场
            }
        }
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int T = scan.nextInt();
            while(T -- > 0)
            {
                n = scan.nextInt();
                m = scan.nextInt();
                int x = scan.nextInt();
                int y = scan.nextInt();
                res = 0;
                st[x][y] = true;
                dfs(x,y,1);
                st[x][y] = false; //恢复现场
                System.out.println(res);
            }
        }
    }

}