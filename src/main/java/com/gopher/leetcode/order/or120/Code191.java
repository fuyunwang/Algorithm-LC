package com.gopher.leetcode.order.or120;

/**
 * @Title Code191
 * @Author fyw
 * @Date 2022/2/1 20:56
 * @Description: 位1的个数，与190题很像，核心在于 n>>i&1 通过确定最靠右的1来确定1的个数
 */
public class Code191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        for (int i = 0; i < 32; i++) {
            if ((n>>i&1)==1)
                res++;
        }
        return res;
    }
}
