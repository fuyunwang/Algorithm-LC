package com.gopher.leetcode;

/**
 * @Title Code231
 * @Author fyw
 * @Date 2022/1/30 21:23
 * @Description:
 */
public class Code231 {
    public boolean isPowerOfTwo(int n) {
        if (n<1)
            return false;
        return (n&(n-1))==0;
    }
}
