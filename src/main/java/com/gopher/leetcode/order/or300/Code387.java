package com.gopher.leetcode.order.or300;

/**
 * @Title Code387
 * @Author fyw
 * @Date 2022/2/8 22:02
 * @Description: 字符串中的第一个唯一字符
 */
public class Code387 {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
