package com.gopher.leetcode.order.or50;

/**
 * @Title Code43
 * @Author fyw
 * @Date 2022/2/1 13:55
 * @Description: 字符串相乘
 */
public class Code43 {
    public String multiply(String num1, String num2) {
        int n1=num1.length()-1;
        int n2=num2.length()-1;
        int[] mul=new int[n1+n2+2];
        for(int i=n1;i>=0;i--){
            for(int j=n2;j>=0;j--){
                int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                temp+=mul[i+j+1];// 关键是num1的第i位和num2的第j位相乘的结果放在了[i+j,i+j+1]位置
                mul[i+j]+=temp/10;
                mul[i+j+1]=temp%10;
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<mul.length-1&&mul[i]==0){
            i++;
        }
        for(;i<mul.length;i++){
            sb.append(mul[i]);
        }
        return sb.toString();
    }
}
