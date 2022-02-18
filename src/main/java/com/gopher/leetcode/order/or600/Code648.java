package com.gopher.leetcode.order.or600;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title Code648
 * @Author fyw
 * @Date 2022/2/18 15:09
 * @Description: 单词替换
 * 可以用字典树
 * 也可以用字符串哈希
 * 用字符串哈希采用P进制，P取131，从而实现将字符串前缀映射成整数
 */
public class Code648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        int P=131;
        Set<Long> set=new HashSet<>();
        for (String dic:dictionary){
            long h = 0;
            for (int i = 0; i < dic.length(); i++) {
                char c=dic.charAt(i);
                h=h*P+c;
            }
            set.add(h);
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            int j=i;
            while (j<sentence.length()&&sentence.charAt(j)!=' ') j++;
            long h=0;
            for (int k = i; k < j; k++) {
                sb.append(sentence.charAt(k));
                h=h*P+sentence.charAt(k);
                if (set.contains(h))
                    break;
            }
            sb.append(' ');
            i=j;
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
