package com.gopher.leetcode.order.or500;

/**
 * @Title Code507
 * @Author fyw
 * @Date 2022/2/17 15:21
 * @Description: 完美数
 * 求正因子
 */
public class Code507 {
    public boolean checkPerfectNumber(int num) {
        int res=0;
        for (int i = 1; i*i < num; i++) {
            if (num%i==0){
                res+=i;
                if (i!=1&&num/i!=i)
                    res+=num/i;
            }
        }
        return res==num;
    }
}
