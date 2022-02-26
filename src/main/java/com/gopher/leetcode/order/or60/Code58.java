package com.gopher.leetcode.order.or60;

/**
 * @Title Code58
 * @Author fyw
 * @Date 2022/2/2 10:44
 * @Description: 最后一个单词的长度
 */
public class Code58 {
    public int lengthOfLastWord(String s) {
        int len=0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i)!=' '){
                len++;
            }else if (len!=0){
                return len;
            }
        }
        return len;
    }
}
