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
//            Character.is
            if (Character.toLowerCase(chars[l++])!=Character.toLowerCase(chars[r++])){
                return false;
            }
        }
        return true;
    }
}
