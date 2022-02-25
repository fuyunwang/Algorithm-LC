package com.gopher.leetcode.order.or400;

/**
 * @Title Code443
 * @Author fyw
 * @Date 2022/2/8 21:56
 * @Description: 压缩字符串
 */
public class Code443 {
    public int compress(char[] chars) {
        int k = 0;
        int n = chars.length;
        for(int i = 0; i < n; i ++) {
            chars[k ++] = chars[i];
            int j = i;
            while(i < n - 1 && chars[i] == chars[i + 1]) i ++;
            int len = i - j + 1;
            if(len == 1) continue;
            else {
                String l = String.valueOf(len);
                for(int m = 0; m < l.length(); m ++)
                    chars[k ++] = l.charAt(m);
            }
        }
        return k;
    }
}
