package com.gopher.leetcode.order.or400;

/**
 * @Title Code424
 * @Author fyw
 * @Date 2022/2/9 14:46
 * @Description: 替换后的最长重复字符
 * 给定替换次数要求替换制定次数之后重复字符构成的最长字符串
 * 滑动窗口
 */
public class Code424 {
    public int characterReplacement(String s, int k) {
        int res = 0;
        for (char c = 'A';c <= 'Z';c++) {
            int j = 0;
            int cnt = 0;
            for (int i = 0;i < s.length();i++) {
                if (s.charAt(i) == c) {
                    cnt++;
                }
                while (i - j + 1 - cnt > k) {
                    if (s.charAt(j) == c) cnt--;
                    j++;
                }
                res = Math.max(res, i -j + 1);
            }
        }
        return res;
    }
}
