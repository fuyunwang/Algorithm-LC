package com.gopher.leetcode.order.or500;

/**
 * @Title Code541
 * @Author fyw
 * @Date 2022/2/9 13:46
 * @Description: 反转字符串
 * 要求每隔K个反转K个，最后不足k的全部反转
 */
public class Code541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length();i+=2*k) {
            StringBuilder sb1=new StringBuilder();
            int firstK= Math.min((i + k), s.length());
            int secondK= Math.min((i + 2 * k), s.length());
            // firstK的部分肯定会反转
            sb1.append(s.substring(i,firstK));
            sb.append(sb1.reverse());
            if (firstK<secondK){
                // 剩余长度大于k
                sb.append(s.substring(firstK,secondK));
            }
        }
        return sb.toString();
    }
}
