package com.fuyunwang.bilibili.order.hot100;

/**
 * @Title Code121
 * @Author fyw
 * @Date 2022/5/24 15:57
 * @Description:
 */
public class Code121 {
    public int maxProfit(int[] prices) {
        int res=0;
        for (int i = 0,min=Integer.MAX_VALUE; i < prices.length; i++) {
            res=Math.max(res,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return res;
    }
}
