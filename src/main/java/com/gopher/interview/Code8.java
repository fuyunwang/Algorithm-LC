package com.gopher.interview;

import java.util.Scanner;

/**
 * @Title Code8
 * @Author fyw
 * @Date 2022/2/8 18:28
 * @Description: 异或和是质数的子集数
 */
public class Code8 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n + 1];
        for(int i = 1 ;i <= n ;i ++) a[i] = sc.nextInt();

        int m = 8192;
        int mod = (int)1e9 + 7;

        int [][] f = new int[2][m];
        f[0][0] = 1;
        for(int i = 1 ;i <= n ;i ++)
            for(int j = 0 ;j < m ;j ++) {
                f[i & 1][j] = f[i - 1 & 1][j];
                if((j ^ a[i]) < m )
                    f[i & 1][j] = (f[i & 1][j] + f[i - 1 & 1][j ^ a[i]]) % mod;
            }

        int res = 0;
        for(int i = 2 ;i < m ;i ++)
            if(isPrime(i)) res = (res + f[n & 1][i]) % mod;

        System.out.println(res);
    }

    public static boolean isPrime(int x) {
        for(int i = 2 ;i * i <= x ;i ++)
            if(x % i == 0) return false;
        return true;
    }
}
