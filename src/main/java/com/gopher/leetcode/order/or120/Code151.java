package com.gopher.leetcode.order.or120;

/**
 * @Title Code151
 * @Author fyw
 * @Date 2022/1/30 17:09
 * @Description: 以单词为最小单位翻转字符串。类似翻转部分数组，先整体翻转再内部局部翻转
 */
public class Code151 {
    public String reverseWords(String s) {
        if (s == null) return "";
        char[] chars = s.toCharArray();
        // 消除多余的空格
        int len = 0; // 字符串最终的有效长度
        int cur = 0; // 当前用来存放字符的位置
        boolean space = true; // 前一个字符是否为空格字符
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != ' ') { // chars[i]是非空格字符
                chars[cur++] = chars[i];
                space = false;
            }
            else if (space == false){ // chars[i]是空格字符，chars[i - 1]是非空格字符
                chars[cur++] = ' ';
                space = true;
            }
        }
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";

        // 对整个有效字符串进行逆序
        reverse(chars, 0, len);

        // 对每一个单词进行逆序
        int prevSpaceIdx = -1; // 前一个空格字符的位置（在-1位置有一个假想的哨兵，就是一个假想的空格字符）
        for (int i = 0; i < len; ++i) {
            if (chars[i] != ' ') continue;
            // i是空格字符的位置
            reverse(chars, prevSpaceIdx + 1, i);
            prevSpaceIdx = i;
        }
        // 翻转最后一个单词
        reverse(chars, prevSpaceIdx + 1, len);

        return new String(chars, 0, len);
    }

    // 将[li, ri)范围内的字符串进行逆序
    private void reverse(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }
    }
    // 用API
    public String reverseWords1(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = str.length - 1; i >= 0; --i) {
            if (str[i].equals("")) continue;
            res.append(str[i] + ' ');
        }
        return res.toString().trim();
    }
}
