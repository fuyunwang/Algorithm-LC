package com.gopher.leetcode.order.or900;

/**
 * @Title Code921
 * @Author fyw
 * @Date 2022/1/29 15:53
 * @Description: 使括号有效的最少添加
 */
public class Code921 {
    public int minAddToMakeValid(String s) {
        int l=0,r=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('){
                l++;
            }else{
                if (l!=0)
                    l--;
                else
                    r++;
            }
        }
        return l+r;
    }
}
