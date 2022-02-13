package com.gopher.leetcode.order.or300;

import java.util.HashMap;

/**
 * @Title Code397
 * @Author fyw
 * @Date 2022/2/8 22:07
 * @Description: 整数替换
 */
public class Code397 {
    // 记忆化搜索
    HashMap<Long,Long> map=new HashMap<>();
    public int integerReplacement(int n) {
        return (int) f(n);
    }
    long f(long n){
        if (map.containsKey(n))
            return map.get(n);
        if (n==1)
            return 0;
        if (n%2==0){
            long temp=f(n/2)+1;
            map.put(n,temp);
            return temp;
        }
        long other=Math.min(f(n-1),f(n+1))+1;
        map.put(n,other);
        return other;
    }
}
