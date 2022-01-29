package com.gopher.leetcode;

/**
 * @Title Code190
 * @Author fyw
 * @Date 2022/1/29 19:27
 * @Description:
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
