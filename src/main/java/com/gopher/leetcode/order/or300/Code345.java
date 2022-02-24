package com.gopher.leetcode.order.or300;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Title Code345
 * @Author fyw
 * @Date 2022/2/9 13:49
 * @Description: 反转字符串中的元音字母
 */
public class Code345 {
    HashSet<Character> dict = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        char[] chrs = s.toCharArray();
        for (int i = 0, j = chrs.length - 1; i < j; i++, j--) {
            while (i < j && !dict.contains(chrs[i])) i++;
            while (i < j && !dict.contains(chrs[j])) j--;
            char tmp = chrs[j];
            chrs[j] = chrs[i];
            chrs[i] = tmp;
        }
        return new String(chrs);
    }

}
