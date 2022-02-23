package com.gopher.leetcode.order.or120;

/**
 * @Title Code121
 * @Author fyw
 * @Date 2022/2/8 21:49
 * @Description: 买卖股票的最佳时机
 * 只能进行一笔交易
 */
public class Code121 {
    public int maxProfit(int[] prices) {
        // 枚举一下每一个点，查看之前的最小值是否可以产生更大的利润
        int res=0;
        for (int i = 0, minVal=Integer.MAX_VALUE; i < prices.length; i++) {
            res=Math.max(res,prices[i]-minVal);
            minVal=Math.min(minVal,prices[i]);
        }
        return res;
    }
}
