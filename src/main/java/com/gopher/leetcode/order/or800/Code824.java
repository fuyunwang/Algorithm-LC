package com.gopher.leetcode.order.or800;

import java.util.HashSet;

/**
 * @Title Code824
 * @Author fyw
 * @Date 2022/2/17 10:11
 * @Description: 山羊拉丁文
 * 简单模拟题
 */
public class Code824 {
    public String toGoatLatin(String sentence) {
        HashSet<Character> set=new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder sb=new StringBuilder();
        for (int i = 0,k=0; i < sentence.length(); i++) {
            int j=i+1;
            while (j<sentence.length()&&sentence.charAt(j)!=' ')
                j++;
            String word=sentence.substring(i,j);
            if (set.contains(Character.toLowerCase(word.charAt(0)))){
                sb.append(word).append("ma");
            }else{
                sb.append(word.substring(1)).append(word.charAt(0)).append("ma");
            }
            k++;
            for (int l = 0; l < k; l++) {
                sb.append('a');
            }
            sb.append(' ');
            i=j;
        }
        return sb.substring(0,sb.length()-1);
    }
}
