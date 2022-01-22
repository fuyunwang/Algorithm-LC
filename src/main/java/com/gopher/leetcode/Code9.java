package com.gopher.leetcode;

/**
 * @Title Code9
 * @Author fyw
 * @Date 2022/1/18 14:39
 * @Description:
 */
public class Code9 {
    public boolean isPalindrome(int x) {
        long result=0;
        while (x!=0){
            result = result * 10 + x%10;
            x/=10;
        }
        return result==x;
    }
}
