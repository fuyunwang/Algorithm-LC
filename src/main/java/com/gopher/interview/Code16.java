package com.gopher.interview;

import java.util.Scanner;

/**
 * @Title Code16
 * @Author fyw
 * @Date 2022-02-22 10:50
 * @Description 圆桌座位
 * 全排列的变形
 */
public class Code16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[][] fr = new boolean[n][n];  //用于存储朋友关系
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            fr[a-1][b-1] = true;
            fr[b-1][a-1] = true;
        }
        boolean[] st = new boolean[n];   //用于节点是否被访问
        st[0] = true;
        System.out.println(dfs(0, st, 1, fr, n));
    }

    /**
     *
     * @param i 用于给节点计数，仅用于递归终止
     * @param st
     * @param pre 上一个节点的值
     * @param fr
     * @param n
     * @return
     */
    private static int dfs(int i, boolean[] st, int pre, boolean[][] fr, int n) {
        if (i == n-1){
            if (fr[pre-1][0]) return 0;
            return 1;
        }
        int res = 0;
        for (int j = 1; j <= n; j++) {
            if (!st[j-1] && !fr[j-1][pre-1]){
                st[j-1] = true;
                res += dfs(i+1, st, j, fr, n);
                st[j-1] = false;
            }
        }
        return res;
    }
}