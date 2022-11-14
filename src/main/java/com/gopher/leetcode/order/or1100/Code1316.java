package com.gopher.leetcode.order.or1100;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @Title Code1316
 * @Author fyw
 * @Date 2022/11/14 20:51
 * @Description 不同的循环子字符串
 * 字符串哈希，O(1)时间判断两个字符串是否相等
 */
public class Code1316 {
    long[] p;
    long[] h;
    int P=131;
    long get(int l,int r){
        return h[r]-h[l-1]*p[r-l+1];
    }
    public int distinctEchoSubstrings(String text) {
        int n=text.length();
        p=new long[n+1];
        h=new long[n+1];
        p[0]=1;
        for (int i = 1; i <= n; i++) {
            p[i]=p[i-1]*P;
            h[i]=h[i-1]*P+text.charAt(i-1);
        }
        Set<Long> set=new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i+j*2-1 <=n; j++) {
                long left=get(i,i+j-1);
                long right=get(i+j,i+j*2-1);
                if (left==right){
                    set.add(left);
                }
            }
        }
        return set.size();
    }
}
