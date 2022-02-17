package com.gopher.leetcode.order.or800;

import java.util.Arrays;

/**
 * @Title Code821
 * @Author fyw
 * @Date 2022/2/17 9:43
 * @Description:
 */
public class Code821 {
    public int[] shortestToChar(String s, char c) {
        int[] res=new int[s.length()];
        Arrays.fill(res,Integer.MAX_VALUE);
        for (int i = 0,j=-1; i < s.length(); i++) {
            if (s.charAt(i)==c) j=i;
            if (j!=-1)
                res[i]=i-j;
        }
        for (int i = s.length()-1,j=-1; i >=0 ; i--) {
            if (s.charAt(i)==c) j=i;
            if (j!=-1)
                res[i]=Math.min(res[i],j-i);
        }
        return res;
    }
}
