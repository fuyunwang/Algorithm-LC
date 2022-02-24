package com.gopher.leetcode.order.or300;

/**
 * @Title Code344
 * @Author fyw
 * @Date 2022/2/8 21:56
 * @Description: 反转字符串
 */
public class Code344 {
    public void reverseString(char[] s) {
        int n=s.length;
        for(int i=0;i<s.length/2;i++){
            char temp=s[i];
            s[i]=s[n-1-i];
            s[n-1-i]=temp;
        }
    }
}
