package com.gopher.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Title BipartiteGraph
 * @Author fyw
 * @Date 2022-02-21 16:00
 * @Description 二分图
 */
public class BipartiteGraph {
    // 判定二分图，二分图中必不含有奇数条边的环
    static class Code1{
        static int n;
        static int m;
        static int N = 100010;
        static int M = 200010;
        static int[] h = new int[N];
        static int[] e = new int[M];
        static int[] ne = new int[M];
        static int idx = 0;
        static int[] color = new int[N];//共1和2两种不同的颜色
        static boolean[] st = new boolean[N];
        public static void add(int a,int b)
        {
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx ++;
        }
        //dfs(u,c)表示把u号点染色成c颜色，并且判断从u号点开始染其他相连的点是否成功
        public static boolean dfs(int u,int c)
        {
            color[u] = c;
            for(int i = h[u];i != -1;i = ne[i])
            {
                int j = e[i];
                if(color[j] == 0)
                {
                    if(!dfs(j,3 - c)) return false;
                }
                else if(color[j] == c) return false;//颜色重复
            }
            return true;
        }
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str1 = reader.readLine().split(" ");
            n = Integer.parseInt(str1[0]);
            m = Integer.parseInt(str1[1]);
            Arrays.fill(h, -1);
            while(m -- > 0)
            {
                String[] str2 = reader.readLine().split(" ");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                // 无向图建立两条有向边
                add(a,b);
                add(b,a);
            }

            boolean flag = true;//标记是否染色成功
            for(int i = 1;i <= n;i++) {
                //若未染色
                if(color[i] == 0) {
                    if(!dfs(i,1)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) System.out.println("Yes");
            else System.out.println("No");
        }
        // bfs
        public static boolean bfs() {
            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i = 1;i <= n;i++) {
                //若该点为未色
                if(color[i] == 0) {
                    color[i] = 1;
                    queue.add(i);
                    while(!queue.isEmpty()) {
                        int t = queue.poll();
                        for(int j = h[t] ;j != -1;j = ne[j]) {
                            int k = e[j];
                            if(color[k] == 0) {
                                color[k] = 3 - color[t];
                                queue.add(k);
                            }
                            else if(color[k] == color[t]) return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    // 二分图最大匹配，匈牙利算法
    static class Code2{
        static int N = 510,M = 100010,n1,n2,m,idx;
        static int[] h = new int[N],e = new int[M],ne = new int[M];
        static int[] match = new int[M];
        static boolean[] st = new boolean[N];
        public static void add(int a,int b){
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx++;
        }
        public static boolean find(int x){
            //每一次遍历一遍传进来的左边集合x对应的右边集合中的点
            for(int i = h[x]; i != -1; i = ne[i]){
                int  j = e[i];
                // 判断这个点是不是已经用过了，没用过继续
                if(!st[j]){
                    //这里st的作用大致就是递归时候起到判重的作用，因为下一位男生遍历时候一开始都会将st初始化为false
                    //然后将这个点标记为有了，然后如果刚好标记之后这个位置的女生已经被上一个男生约定俗成了，
                    //就递归看看这个男生是不是还有其他可以喜欢的女生，这个时候判重的作用就体现了，因为在这个过程中
                    //st已经被true标记了，所以上一个男生重新遍历时候遍历到这个女生就知道要让给下一个男生，所以找到
                    //自己的其他中意的女生，然后将自己与另外以为女生绑定，如果没有其他喜欢的女生，就返回flase，
                    //然后下一个男生就是单生，或者看看自己还有没有其他喜欢的女生，以此类推，得出最完美结果！！！
                    st[j] = true;
                    if(match[j] == 0 || find(match[j])){
                        match[j] = x; //match是表示女生对应的男生是谁
                        return true;
                    }
                }
            }
            return false;
        }
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            n1 = scan.nextInt();
            n2 = scan.nextInt();
            m = scan.nextInt();
            Arrays.fill(h,-1);
            while(m -- > 0){
                int a = scan.nextInt();
                int b = scan.nextInt();
                add(a,b);
            }
            //统计最大匹配
            int res = 0;
            //遍历一下所有左半边集合的点，即所有的男生
            for(int  i = 1 ; i <= n1 ; i ++ ){
                //每一次模拟都要将st数组清空,这个判断重复的点,match是物有所主了
                //st数组用来保证本次匹配过程中，右边集合中的每个点只被遍历一次，防止死循环。
                //match存的是右边集合中的每个点当前匹配的点是哪个，但就算某个点当前已经匹配了某个点，
                //也有可能被再次遍历，所以不能起到判重的作用。
                Arrays.fill(st,false);
                if(find(i)) res ++ ;
            }
            System.out.println(res);
        }
    }
}
