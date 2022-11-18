package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1221
 * @Author fyw
 * @Date 2022/2/9 13:55
 * @Description: 平衡字符串
 * 贪心
 */
public class Code1221 {
    public int balancedStringSplit(String s) {
        int res=0;
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='L'){
                cnt++;
            }else{
                cnt--;
            }
            if (cnt==0)
                res++;
        }
        return res;
    }
}
