package com.gopher.leetcode;

/**
 * @Title Code2000
 * @Author fyw
 * @Date 2022/2/2 10:53
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
