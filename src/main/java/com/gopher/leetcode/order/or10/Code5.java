package com.gopher.leetcode.order.or10;

/**
 * @Title Code5
 * @Author fyw
 * @Date 2022/1/21 14:16
 * @Description:
 */
public class Code5 {
    public String longestPalindrome(String s) {
        String result="";
        for (int i = 0; i < s.length(); i++) {
            // 考虑偶回文的情况
            int left=i,right=i+1;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if (result.length()<right-1-left){
                result=s.substring(left+1,right);
            }
            //奇回文的情况
            left=i;right=i;
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if (result.length()<right-1-left){
                result=s.substring(left+1,right);
            }
        }
        return result;
    }
}
