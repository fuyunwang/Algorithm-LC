package com.gopher.leetcode.order.or120;

/**
 * @Title Code190
 * @Author fyw
 * @Date 2022/1/29 19:27
 * @Description: 颠倒二进制位
 */
public class Code190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for (int i = 0; i < 32; i++) {
            res=(res<<1)+(n>>i&1);
        }
        return res;
    }
}
