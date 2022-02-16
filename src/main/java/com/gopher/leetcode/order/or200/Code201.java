package com.gopher.leetcode.order.or200;

/**
 * @Title Code201
 * @Author fyw
 * @Date 2022/2/16 19:29
 * @Description: 数字范围按位与
 */
public class Code201 {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for(int i = 30;i >= 0;i --)
        {
            if((m >> i & 1) != (n >> i & 1)) break;
            if((m >> i & 1) == 1) res += 1 << i;
        }
        return res;
    }
}
