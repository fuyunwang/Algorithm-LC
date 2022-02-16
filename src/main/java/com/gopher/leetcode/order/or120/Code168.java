package com.gopher.leetcode.order.or120;

/**
 * @Title Code168
 * @Author fyw
 * @Date 2022/2/8 21:07
 * @Description: 给定数字返回excel列名
 */
public class Code168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while (columnNumber>0){
            columnNumber--;
            sb.append((char)(columnNumber%26+'A'));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
}
