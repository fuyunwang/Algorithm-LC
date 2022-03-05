package com.gopher.leetcode.types.math;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-05 21:26
 * @Description
 */
public class Template1 {
    static class Code1071{
        int gcd(int a,int b){
            return b!=0?gcd(b,a%b):a;
        }
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1+str2).equals(str2+str1)){
                return "";
            }
            return str1.substring(0,gcd(str1.length(),str2.length()));
        }
    }
}
