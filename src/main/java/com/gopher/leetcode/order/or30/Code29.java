package com.gopher.leetcode.order.or30;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code29
 * @Author fyw
 * @Date 2022/2/9 12:28
 * @Description: 两数相除
 */
public class Code29 {
    //计算x * b
    static long mul(long a,long k)
    {
        long res = 0;
        while(k > 0)
        {
            if((k & 1) == 1) res += a;
            k >>= 1;
            a += a;
        }
        return res;
    }
    public int divide(int x, int y) {
        List<Long> exp = new ArrayList<Long>();
        long a = x,b = y;
        boolean flag = false;//表示是不是负数
        if (a < 0 && b > 0 || a > 0 && b < 0) flag = true;

        if(a < 0) a = -a;
        if(b < 0) b = -b;

        long l = 0,r = a;
        while(l < r)
        {
            long mid = l + r + 1 >> 1;
            if(mul(mid,b) <= a) l = mid;
            else r = mid - 1;
        }
        long res = l;

        if(flag) res = -res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) res = Integer.MAX_VALUE;

        return (int)res;
    }

}
