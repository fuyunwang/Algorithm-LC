package com.gopher.leetcode.order.or120;

/**
 * @Title Code125
 * @Author fyw
 * @Date 2022/2/9 13:46
 * @Description: 验证回文串
 */
public class Code125 {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        final char[] chars = s.toCharArray();
        while (l<r){
            char lc=chars[l];
            char rc=chars[r];
            if(!Character.isLetterOrDigit(lc)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(rc)){
                r--;
                continue;
            }
            if (Character.toLowerCase(lc)!=Character.toLowerCase(rc)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
