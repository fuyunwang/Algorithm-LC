package com.gopher.leetcode.order.or1000;

/**
 * @Title Code1071
 * @Author fyw
 * @Date 2022/2/17 21:11
 * @Description: 字符串的最大公因子
 */
public class Code1071 {
    /**
     * 字符串的最大公因子的长度肯定是小于等于两个原字符串长度的最大公约数，因为都可以整除
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1+str2).equals(str2+str1))
            return "";
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }
    int gcd(int a,int b){           // 求最大公约数
        return b!=0?gcd(b,a%b):a;
    }
}
