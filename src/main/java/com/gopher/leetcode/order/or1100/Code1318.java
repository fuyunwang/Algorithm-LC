package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1318
 * @Author fyw
 * @Date 2022/11/14 21:47
 * @Description 或运算的最小翻转次数
 */
public class Code1318 {
    public int minFlips(int a, int b, int c) {
        int res=0;
        for (int i = 0; i < 30; i++) {
            int x = a >> i & 1, y = b >> i & 1, z = c >> i & 1;
            if (z==0) res+=x+y;     // 此时两位必须都为0，如果是1就翻转一次即可
            else if (x==0&&y==0)    // 此时翻转任意一位即可
                res++;
        }
        return res;
    }
}
