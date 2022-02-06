package com.gopher.leetcode.order.or20;

/**
 * @Title Code14
 * @Author fyw
 * @Date 2022/1/22 13:18
 * @Description: 最长公共前缀，暴力枚举
 */
public class Code14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
