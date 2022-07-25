package com.gopher.leetcode.order.or300;

/**
 * @Title Code390
 * @Author fyw
 * @Date 2022/2/9 13:30
 * @Description: 消除游戏
 * 约瑟夫环
 */
public class Code390 {
    public int lastRemaining(int n) {
        /**
         * 第一次从左往右删除，最后的编号记为f(n)；
         * 第一次从右往左删除，最后的编号记为g(n)
         */
        if(n==1)
            return 1;
        return 2*(n/2+1-lastRemaining(n/2));
    }
}
