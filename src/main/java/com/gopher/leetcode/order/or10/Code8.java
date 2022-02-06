package com.gopher.leetcode.order.or10;

/**
 * @Title Code8
 * @Author fyw
 * @Date 2022/1/21 13:38
 * @Description:
 */
public class Code8 {
    public int myAtoi(String s) {
        int index=0;
        while (index<s.length()&&s.charAt(index)==' '){
            index++;
        }
        if (index==s.length()){
            return 0;
        }
        int flag=1;
        if (s.charAt(index)=='-'){
            index++;
            flag=-1;
        }else if (s.charAt(index)=='+'){
            index++;
        }
        int result=0;
        while (index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
            int x = s.charAt(index) - '0';
            if(flag >0 &&result> (Integer.MAX_VALUE - x) / 10)
                return Integer.MAX_VALUE;
            if(flag <0 && -result< (Integer.MIN_VALUE+x)/10)
                return Integer.MIN_VALUE;
            if (-result * 10 - x == Integer.MIN_VALUE) return Integer.MIN_VALUE;
            result = result * 10 + x;
            index++;
        }
        result*=flag;

        return result;
    }
}
