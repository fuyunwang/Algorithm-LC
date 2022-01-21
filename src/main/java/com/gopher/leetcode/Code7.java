package com.gopher.leetcode;

/**
 * @Title Code7
 * @Author fyw
 * @Date 2022/1/21 14:53
 * @Description:
 */
public class Code7 {
    public int reverse(int x) {
        int result=0;
        while (x!=0){
            if (result>0&&result >(Integer.MAX_VALUE- x%10)/10||result<0&&result<(Integer.MIN_VALUE-x%10)/10)
                return 0;
            result = result * 10 + x % 10;
            x/=10;
        }
        return result;
    }
}
