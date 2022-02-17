package com.gopher.leetcode.order.or500;

/**
 * @Title Code509
 * @Author fyw
 * @Date 2022/2/8 22:05
 * @Description: 斐波那契数
 */
public class Code509 {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = a+b;
        // 状态压缩之后类似辗转相除
        for (int i = 2; i <= n; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
