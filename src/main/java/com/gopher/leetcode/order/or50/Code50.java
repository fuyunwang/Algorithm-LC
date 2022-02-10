package com.gopher.leetcode.order.or50;

/**
 * @Title Code50
 * @Author fyw
 * @Date 2022/2/10 21:50
 * @Description: Pow
 * 快速幂，类似两数相除Code29
 */
public class Code50 {
    public double myPow(double x, int n) {
        long num = n;
        double t = qmi(x,Math.abs(num));
        if(n < 0) return 1 / t;
        return t;
    }
    public double qmi(double a,long k){
        double res=1;
        while (k>0){
            if ((k&1)==1) res*=a; // 判断k的二进制表示最后一位是否为1。&1相当于%2
            k>>=1;
            a*=a;
        }
        return res;
    }
}
