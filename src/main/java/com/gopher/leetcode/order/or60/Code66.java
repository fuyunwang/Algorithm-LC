package com.gopher.leetcode.order.or60;

/**
 * @Title Code66
 * @Author fyw
 * @Date 2022/2/8 11:58
 * @Description: 数组加一
 */
public class Code66 {
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]+=1;
                return digits;
            }
        }
        int[] res=new int[digits.length+1];
        res[0]=1;
        return res;
    }
}
