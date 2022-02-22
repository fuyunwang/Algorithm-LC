package com.gopher.interview;

import java.util.Scanner;

/**
 * @Title Code7
 * @Author fyw
 * @Date 2022/2/8 18:26
 * @Description: 鸡蛋掉落，LeetCode889
 * dp
 * 可控的选择取最小，不可控的情况取最大
 */
public class Code7 {
    static class Access1{
        int n; // n层楼
        int m; // m个鸡蛋
        int[][] f=new int[n][m];    // f[i][j]表示用j个鸡蛋测i层楼时最差情况的最好选择
        public void access(){
            for (int i = 1; i <= n; i ++ ) f[i][1] = i;
            for (int i = 1; i <= m; i ++ ) f[1][i] = 1;

            for (int i = 2; i <= n; i ++ )
                for (int j = 2; j <= m; j ++ ) {
                    f[i][j] = f[i][j - 1];
                    for (int k = 1; k <= i; k ++ )
                        f[i][j] = Math.min(f[i][j], Math.max(f[k - 1][j - 1], f[i - k][j]) + 1);
                }
        }
    }
    static class Access2{
        // 所有用j个鸡蛋测i次能最多测量多长区间
        /**
        f(i, j)
        状态表示：集合：所有用j个鸡蛋测i次的测量方案的集合
                属性：最多能测量多长的区间
        状态计算：f(i,j) = f(i-1, j-1) + f(i-1, j) + 1;
        */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                int n = scanner.nextInt(); //楼的高度
                int m = scanner.nextInt(); //鸡蛋的数量
                int[][] f = new int[n+1][m+1];

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        f[i][j] = f[i-1][j-1] + f[i-1][j] + 1;
                    }
                    if (f[i][m] >= n){
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
}
