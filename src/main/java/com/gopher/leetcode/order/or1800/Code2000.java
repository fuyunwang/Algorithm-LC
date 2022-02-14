package com.gopher.leetcode.order.or1800;

/**
 * @Title Code2000
 * @Author fyw
 * @Date 2022/2/14 11:31
 * @Description:
 */
public class Code2000 {
    public String reversePrefix(String word, char ch) {
        final int i = word.indexOf(ch);
        if (i<=0){
            return word;
        }
        String temp=word.substring(0,i+1);
        StringBuilder tempSb=new StringBuilder(temp);
        tempSb.reverse().append(word.substring(i+1,word.length()));
        return tempSb.toString();
    }
}
