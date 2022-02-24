package com.gopher.leetcode.order.or300;

/**
 * @Title Code392
 * @Author fyw
 * @Date 2022/2/9 14:41
 * @Description: 判断s是否是t的子序列
 */
public class Code392 {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        for (int j = 0; j < t.length(); j++) {
            if (i<s.length()&&s.charAt(i)==t.charAt(j)){
                i++;
            }
        }
        return i==s.length();
    }
}
