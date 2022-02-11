package com.gopher.leetcode.order.or60;

/**
 * @Title Code67
 * @Author fyw
 * @Date 2022/2/9 12:38
 * @Description: 二进制求和
 * 利用两数求和的思路，主要是翻转
 */
public class Code67 {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        final char[] achars = a.toCharArray();
        final char[] bchars = b.toCharArray();
        reverse(achars,0,achars.length-1);
        reverse(bchars,0,bchars.length-1);
        for (int i = 0, j=0,temp=0; i < achars.length||j<bchars.length||temp!=0; i++,j++) {
            if (i<achars.length) temp+=(achars[i]-'0');
            if (j<bchars.length) temp+=(bchars[j]-'0');
            sb.append(temp%2);
            temp/=2;
        }
        return sb.reverse().toString();
    }
    public void reverse(char[] strs,int begin,int end){
        while (begin<end){
            char temp=strs[begin];
            strs[begin]=strs[end];
            strs[end]=temp;
            begin++;
            end--;
        }
    }
}
