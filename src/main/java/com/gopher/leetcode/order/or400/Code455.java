package com.gopher.leetcode.order.or400;

import java.util.Arrays;

/**
 * @Title Code455
 * @Author fyw
 * @Date 2022/2/9 12:39
 * @Description: 分发饼干
 */
public class Code455 {
    public int findContentChildren(int[] g, int[] s) {
        int child=0;
        int sIndex=0;
        Arrays.sort(s);
        Arrays.sort(g);
        while (sIndex<s.length&&child<g.length){
            if (g[child]<=s[sIndex]){
                child++;
            }
            sIndex++;
        }
        return child;
    }
}
