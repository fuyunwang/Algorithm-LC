package com.gopher.leetcode.order.or600;

/**
 * @Title Code696
 * @Author fyw
 * @Date 2022/11/17 20:10
 * @Description 计数二进制子串
 */
public class Code696 {
    public int countBinarySubstrings(String s) {
        int res=0;
        int lastLen=0;
        for (int i = 0; i < s.length(); i++) {
            int j=i+1;
            while (j<s.length()&&s.charAt(j)==s.charAt(j-1))
                j++;
            int curLen=j-i;
            res+=Math.min(curLen,lastLen);
            lastLen=curLen;
            i=j-1;
        }
        return res;
    }
}
