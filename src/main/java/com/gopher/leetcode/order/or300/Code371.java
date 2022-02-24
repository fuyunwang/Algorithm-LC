package com.gopher.leetcode.order.or300;

/**
 * @Title Code371
 * @Author fyw
 * @Date 2022/2/9 13:36
 * @Description: 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 */
public class Code371 {
    public int getSum(int a, int b) {
        // a^b 不进位加法
        // (a&b)<<1 进位
//        return (a^b)+((a&b)<<1);
        if(a == 0) return b;
        if(b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }

}
