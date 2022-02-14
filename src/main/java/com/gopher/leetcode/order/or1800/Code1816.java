package com.gopher.leetcode.order.or1800;

/**
 * @Title Code1816
 * @Author fyw
 * @Date 2022/2/8 21:10
 * @Description: 截断句子
 */
public class Code1816 {
    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '&&--k==0){
                return s.substring(0,i);
            }
        }
        return s;
    }
}
