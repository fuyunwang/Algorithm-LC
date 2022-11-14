package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1328
 * @Author fyw
 * @Date 2022/11/14 21:01
 * @Description 破坏回文串
 */
public class Code1328 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length()<=1)
            return "";
        char[] raw=palindrome.toCharArray();
        for (int i = 0; i < raw.length; i++) {
            if (raw[i]!='a'&&(raw.length%2==0||i!=raw.length/2)){
                raw[i]='a';
                return new String(raw);
            }
        }
        raw[raw.length-1]='b';
        return new String(raw);
    }
}
