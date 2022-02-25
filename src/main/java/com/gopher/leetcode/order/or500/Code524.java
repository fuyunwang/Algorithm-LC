package com.gopher.leetcode.order.or500;

import java.util.List;

/**
 * @Title Code524
 * @Author fyw
 * @Date 2022/2/9 13:52
 * @Description: 通过删除字母匹配到字典里最长单词
 */
public class Code524 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                // compareTo判断字典序
                if (res.isEmpty() || res.length() < str.length() || (res.length() == str.length() && res.compareTo(str) > 0))
                    res = str;
            }
        }
        return res;
    }

    // 判断字符串a是否是字符串b的子序列
    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }

}
