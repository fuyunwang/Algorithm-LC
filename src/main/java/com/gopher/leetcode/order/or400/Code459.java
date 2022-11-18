package com.gopher.leetcode.order.or400;

import java.util.HashSet;

/**
 * @Title Code459
 * @Author fyw
 * @Date 2022/11/18 11:04
 * @Description 重复的子字符串
 */
public class Code459 {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        if (n<=1)
            return false;
        HashSet<String> set=new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (n%i!=0)
                continue;
            set.clear();
            for (int j = 0; j <= n-i; j+=i) {
                set.add(s.substring(j,j+i));
            }
            if (set.size()==1)
                return true;
        }
        return false;
    }
}
