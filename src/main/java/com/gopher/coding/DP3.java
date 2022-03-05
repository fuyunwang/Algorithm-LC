package com.gopher.coding;

import java.util.*;
import java.io.*;

/**
 * @Title DP3
 * @Author fyw
 * @Date 2022-02-21 18:53
 * @Description 数位统计DP 状态压缩DP 树形DP 记忆化搜索
 */
public class DP3 {
    static class Code1{
        // 计数问题，数位统计DP
        /**
         * 给定两个整数 a 和 b，求 a 和 b 之间的所有数字中 0∼9 的出现次数。
         *
         * 例如，a=1024，b=1032，则 a 和 b 之间共有 9 个数如下：
         *
         * 1024 1025 1026 1027 1028 1029 1030 1031 1032
         *
         * 其中 0 出现 10 次，1 出现 10 次，2 出现 7 次，3 出现 3 次等等…
         */

        static int get(List<Integer> list, int l, int r){
            int res = 0;
            for(int i=l; i>=r; i--){
                res = res * 10 + list.get(i);
            }
            return res;
        }

        static int power10(int x){
            int res = 1;
            while(x!=0){
                res *= 10;
                x--;
            }
            return res;
        }

        //统计从1-n，x出现的次数
        static int count(int n, int x){
            if(n==0) return 0; //如果n为0，那直接返回0就行了
            List<Integer> l = new ArrayList<>();

            //将n的每一位加入到l中
            while(n!=0){
                l.add(n % 10);
                n /= 10;
            }
            int len = l.size();

            //对于0,不需要枚举最高位
            int res = 0;
            for(int i=len-1-(x==0?1:0); i>=0; i--){
                if(i < len-1){
                    res += get(l, len-1, i+1) * power10(i);
                    if(x == 0) res -= power10(i);
                }

                if(l.get(i) > x) res += power10(i);
                else if(l.get(i) == x) res += get(l, i-1, 0) + 1;
            }

            return res;
        }

        public static void main(String[] args) throws IOException{
            // 输入以空格分开的两个数
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] arr = in.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            while(a!=0 || b!=0){
                if(a > b){
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                //枚举每一个数字，输出
                for(int i=0; i<=9; i++){
                    System.out.print(count(b, i)-count(a-1, i)+" ");
                }
                System.out.println();

                String[] cur = in.readLine().split(" ");
                a = Integer.parseInt(cur[0]);
                b = Integer.parseInt(cur[1]);
            }
        }

    }

    static class Code2{
        // 状态压缩DP
    }

    static class Code3{
        // 树形DP
        // 状态表示：
            //  f[u][0]：所有以u为根的子树中选择，并且不选u这个点的方案
            //  f[u][1]：所有以u为根的子树中选择，并且选u这个点的方案
        // 状态计算：
            // 当前u结点不选，子结点可选可不选
            // f[u][0]=∑max(f[si,0],f[si,1])
            // 当前u结点选，子结点一定不能选
            // f[u][1]=∑(f[si,0])
        static int N = 6010;
        static int[] happy = new int[N];    // 存储每个人的高兴度，目的就是求快乐指数的最大总和
        static int[] h = new int[N];
        static int[] e = new int[N];
        static int[] ne = new int[N];
        static int idx = 0;
        static int[][] f = new int[N][2];
        static boolean[] has_fa = new boolean[N];   // 标记哪个节点有父节点，找到根节点

        static void dfs(int u) {
            f[u][1] = happy[u];
            for(int i = h[u]; i != -1;i = ne[i])
            {
                int j = e[i];
                dfs(j);     // 注意求和公式，所以这里先处理所有孩子节点

                f[u][1] += f[j][0];
                f[u][0] += MathTemplate.max(f[j][1], f[j][0]);
            }
        }
        public static void main(String[] args) {
            // 初始化与构图
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            for(int i = 1;i <= n;i ++) happy[i] = scan.nextInt();
            Arrays.fill(h, -1);
            for(int i = 0;i < n - 1;i ++)
            {
                int a = scan.nextInt();
                int b = scan.nextInt();
                add(b,a);
                has_fa[a] = true;
            }
            int root = 1;
            while(has_fa[root]) root ++;
            // 从根节点开始dfs
            dfs(root);
            System.out.println(MathTemplate.max(f[root][0], f[root][1]));
        }
        static void add(int a,int b)
        {
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx ++;
        }

    }

    static class Code4{
        // 记忆化搜索
        // 滑雪，从矩阵中的大值依次遍历直到走过一条最长的递减路
        // 状态表示：所有从[i,j]开始滑的路径，属性是路径的最大值
        // 状态计算：
            //
        // 使用记忆化数组 记录每个点的最大滑动长度
        // 遍历每个点作为起点
        // 然后检测该点四周的点 如果可以滑动到其他的点
        // 那么该点的最大滑动长度 就是其他可以滑到的点的滑动长度+1
        // dp[i][j] = max(dp[i][j-1], dp[i][j+1],dp[i-1][j],dp[i+1][j])

        static int N = 310;
        static int n,m;
        static int[][] h = new int[N][N];
        static int[][] f = new int[N][N];
        static int[] dx = new int[] {0,-1,0,1};
        static int[] dy = new int[] {-1,0,1,0};
        static int dfs(int x,int y)
        {
            if(f[x][y] != -1) return f[x][y];

            f[x][y] = 1;
            for(int i = 0;i < 4;i ++)
            {
                int a = x + dx[i];
                int b = y + dy[i];
                if(a < 0 || a >= n || b < 0 || b >= m) continue;
                if(h[x][y] > h[a][b]) f[x][y] = MathTemplate.max(f[x][y], dfs(a,b) + 1);
            }
            return f[x][y];
        }
        public static void main(String[] args) {
            // 初始化
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
            m = scan.nextInt();
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < m;j ++)
                    h[i][j] = scan.nextInt();
            }

            for(int i = 0;i < n;i ++) Arrays.fill(f[i], -1);
            // 记忆化搜索
            int res = 0;
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < m;j ++) {
                    res = MathTemplate.max(res, dfs(i,j));
                }
            }
            System.out.println(res);
        }

    }
}
