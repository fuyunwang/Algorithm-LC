package com.gopher.leetcode.order.or600;

import java.util.HashMap;

/**
 * @Title Code600
 * @Author fyw
 * @Date 2022/2/9 14:09
 * @Description: 不含连续1的非负整数
 */
public class Code600 {
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
