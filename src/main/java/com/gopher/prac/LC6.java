package com.gopher.prac;

/**
 * @Title LC6
 * @Author fyw
 * @Date 2022-03-01 20:29
 * @Description
 */
public class LC6 {
    public String convert(String s, int numRows) {
        if (s.length()==0||numRows==1){
            return s;
        }
        // 枚举每一行，计算对应索引并添加
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i==0||i==numRows-1){
                for (int j = i; j < s.length(); j+=numRows*2-2) {
                    sb.append(s.charAt(j));
                }
            }else{
                for (int j = i,k=2*numRows-2-j; j < s.length()||k<s.length(); j+=numRows*2-2,k+=numRows*2-2) {
                    if (j<s.length()){
                        sb.append(s.charAt(j));
                    }
                    if (k<s.length()){
                        sb.append(s.charAt(k));
                    }
                }
            }
        }
        return sb.toString();
    }
}
