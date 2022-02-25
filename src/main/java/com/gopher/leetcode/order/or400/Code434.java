package com.gopher.leetcode.order.or400;

/**
 * @Title Code434
 * @Author fyw
 * @Date 2022/2/9 12:41
 * @Description: 字符串中的单词数
 */
public class Code434 {
    public int countSegments(String s) {
        s = s.trim();
        if (s.equals("")){
            return 0;
        }
        int res=0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)!=' '&&s.charAt(i+1)==' '){
                res++;
            }
        }
        return res+1;
    }
}
