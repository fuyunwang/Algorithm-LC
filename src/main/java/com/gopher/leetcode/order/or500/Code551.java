package com.gopher.leetcode.order.or500;

/**
 * @Title Code551
 * @Author fyw
 * @Date 2022/2/9 14:11
 * @Description: 学生出勤记录
 *
 */
public class Code551 {
    public boolean checkRecord(String s) {
        for (int i = 0,a=0,l=0; i < s.length(); i++) {
            if (s.charAt(i)=='A'){
                a++;
                l=0;
            }else if (s.charAt(i)=='L'){
                l++;
            }else{
                l=0;
            }
            if (a>1||l>2)
                return false;
        }
        return true;
    }
}
