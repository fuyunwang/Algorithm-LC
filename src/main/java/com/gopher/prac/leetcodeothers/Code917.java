package com.gopher.prac.leetcodeothers;

/**
 * @Title Code917
 * @Author fyw
 * @Date 2022-02-23 9:21
 * @Description
 */
public class Code917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left=0,right=s.length()-1;
        while (left<right){
            char ltemp=chars[left];
            char rtemp=chars[right];
            if (!Character.isLetter(ltemp)){
                left++;
                continue;
            }
            if (!Character.isLetter(rtemp)){
                right--;
                continue;
            }
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}