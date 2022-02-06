package com.gopher.leetcode.order.or10;

/**
 * @Title Code6
 * @Author fyw
 * @Date 2022/1/21 14:44
 * @Description:
 */
public class Code6 {
    public String convert(String s, int numRows) {
        if (s.length()==1||numRows==1)
            return s;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i==0||i==numRows-1){
                for (int j = i; j < s.length(); j+=2*numRows-2) {
                    sb.append(s.charAt(j));
                }
            }else{
                for (int j = i, k = 2*numRows-2-j; j <s.length() || k<s.length(); j+=2*numRows-2,k+=2*numRows-2) {
                    if (j< s.length())
                        sb.append(s.charAt(j));
                    if (k<s.length())
                        sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }
}
