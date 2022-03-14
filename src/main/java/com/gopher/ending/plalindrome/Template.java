package com.gopher.ending.plalindrome;

/**
 * @Title Template
 * @Author fyw
 * @Date 2022/3/12 17:46
 * @Description:
 */
public class Template {
    static class Code214{
        // 方法1，考虑逆序
        public String shortestPalindrome1(String s) {
            String reverse = new StringBuffer(s).reverse().toString();
            for(int i=0;i<reverse.length();i++){
                if(s.startsWith(reverse.substring(i))){
                    return reverse.substring(0,i)+s;
                }
            }
            return "";
        }
    }
    static class Code409{
        // 最长回文串

    }
}
