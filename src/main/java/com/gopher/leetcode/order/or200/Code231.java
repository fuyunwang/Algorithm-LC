package com.gopher.leetcode.order.or200;

/**
 * @Title Code231
 * @Author fyw
 * @Date 2022/1/30 21:23
 * @Description: 2 的幂
 */
public class Code231 {
    public boolean isPowerOfTwo(int n) {
        if (n<1)
            return false;
        return (n&(n-1))==0;
    }
}
