package com.gopher.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Title NQueen
 * @Author fyw
 * @Date 2022/2/20 22:08
 * @Description:
 */
public class NQueen {
    static int N = 20;
    static char[][] g = new char[N][N];
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N];//正斜
    static boolean[] udg = new boolean[N];//反斜
    //按行递归
    static void dfs(int y,int n)
    {
        if(y == n)
        {
            for (int i = 0; i < n; i ++ )
            {
                for (int j = 0; j < n; j ++ )
                    System.out.print(g[i][j]);
                System.out.println();
            }
            System.out.println();
            return;

        }
        for(int x = 0;x < n;x++)        // 按行枚举这一行的每列
        {   // 只处理合法的情况，不合法的情况直接剪枝提前回溯
            if(!col[x] && !dg[y - x + n] && !udg[x + y]) // 当前列、反对角线、对角线都没出现过
            {

                g[y][x] = 'Q';
                col[x] = true;
                dg[y - x + n] = true;
                udg[x + y] = true;
                dfs(y + 1,n);
                col[x] = false;
                dg[y - x + n] = false;
                udg[x + y] = false;
                g[y][x] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i ++ )
            for (int j = 0; j < n; j ++ )
                g[i][j] = '.';

        dfs(0,n); // 按行搜索
    }

    static class Code2{
        static int N = 15;
        static char[][] path = new char[N][N];
        static boolean[] lie = new boolean[N];
        static boolean[] hang = new boolean[N];
        static boolean[] dui1 = new boolean[2*N-1];
        static boolean[] dui2 = new boolean[2*N-1];
        static int n;

        //这里i，j表示当前位置，sum表示已经放置皇后的数量
        static void dfs(int i, int j, int sum){
            if(j == n){
                j=0;
                i+=1;
            }
            if(i ==n ){
                if(sum == n){
                    for(int o=0; o<n; o++){
                        for(int p=0; p<n; p++){
                            System.out.print(path[o][p]);
                        }
                        System.out.println();
                    }

                    System.out.println();
                }

                return;
            }

            //不选
            dfs(i, j+1, sum);

            //选
            if(!hang[i] && !lie[j] && !dui1[i+j] && !dui2[i-j+n]){
                hang[i] = true;
                lie[j] = true;
                dui1[i+j] = true;
                dui2[i-j+n] = true;
                path[i][j] = 'Q';
                dfs(i, j+1, sum+1);
                path[i][j] = '.';
                hang[i] = false;
                lie[j] = false;
                dui1[i+j] = false;
                dui2[i-j+n] = false;
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(in.readLine());

            for(int i=0; i<n; i++) Arrays.fill(path[i], '.');
            dfs(0, 0, 0);
        }
    }

}
