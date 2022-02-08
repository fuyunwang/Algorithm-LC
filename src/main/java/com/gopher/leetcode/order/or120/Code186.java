package com.gopher.leetcode.order.or120;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code186
 * @Author fyw
 * @Date 2022/2/1 20:25
 * @Description: 翻转字符串里的单词 II
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 */
public class Code186 {
    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);
        int i=0;
        int pre=i;
        for (; i <= s.length;) {
            if (i<s.length&&s[i]==' '||i==s.length){
                reverse(s,pre,i-1);
                pre=i+1;
                i++;
            }else{
                i++;
            }
        }
    }
    void reverse(char[] chars,int l,int r){
        while (l<r){
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
    }
}
