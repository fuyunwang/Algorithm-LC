package com.gopher.leetcode.order.or300;

/**
 * @Title Code318
 * @Author fyw
 * @Date 2022/2/9 14:03
 * @Description: 最大单词长度乘积
 * 给你一个字符串数组words ，找出并返回 length(words[i]) * length(words[j])的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 */
public class Code318 {
    /**
     * 本题的核心在于快速判断两个单词是否含有公共字母，由于数据范围规定在26种字符以内，故而可以随时用二进制的方式求解
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] state=new int[n];
        for (int i = 0; i < words.length; i++) {
            int sum=0;
            for (int j = 0; j < words[i].length(); j++) {
                sum|=1<<(words[i].charAt(j)-'a');
            }
            state[i]=sum;
        }
        int res=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((state[i]&state[j])==0){
                    // 此时说明没有公共字母
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
