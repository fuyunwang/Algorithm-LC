package com.gopher.leetcode.order.or500;

/**
 * @Title Code557
 * @Author fyw
 * @Date 2022/2/7 12:48
 * @Description:
 */
public class Code557 {
    public String reverseString(char[] s) {
        int left=0,right=s.length-1;
        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
        return new String(s);
    }

    public String reverseWords(String s) {
        final String[] strs = s.split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            final String string = reverseString(strs[i].toCharArray());
            if (i!=strs.length-1){
                stringBuilder.append(string);
                stringBuilder.append(" ");
            }
            else stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
