package com.gopher.leetcode.order.or120;

/**
 * @Title Code122
 * @Author fyw
 * @Date 2022/2/9 13:48
 * @Description: 买卖股票的最佳时机
 * 可以进行任意多笔交易，但是多笔交易不能有交集
 */
public class Code122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        for(int i = 0;i < n - 1;i ++) {
            int d = prices[i + 1] - prices[i];
            if(d > 0) res += d; // 每个阶段有上升趋势就加入
        }
        return res;
    }
}
