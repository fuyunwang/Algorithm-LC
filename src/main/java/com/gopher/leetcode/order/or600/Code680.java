package com.gopher.leetcode.order.or600;

/**
 * @Title Code680
 * @Author fyw
 * @Date 2022/11/17 20:33
 * @Description 验证回文串
 */
public class Code680 {
    boolean check(String s,int i,int j){
        while (i<j){
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for (int i = 0, j=s.length()-1; i < j; i++,j--) {
            if (s.charAt(i)!=s.charAt(j)){
                if (check(s,i+1,j)||check(s,i,j-1))
                    return true;
                else
                    return false;
            }
        }
        return true;
    }
}
