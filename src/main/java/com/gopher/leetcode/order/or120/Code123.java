package com.gopher.leetcode.order.or120;

/**
 * @Title Code123
 * @Author fyw
 * @Date 2022/2/9 13:49
 * @Description: 买卖股票的最佳时机III
 * 可以进行最多两笔交易
 * 前后缀分解，枚举两次交易的分界点即第二次交易股票买入的时间。第一次交易1~i-1，第二次交易i~n
 * 第二次交易可以视作121题，即枚举i+1~n的最大值
 * 类似最大的和
 */
public class Code123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f = new int[n + 10];//从0到i 卖 - 买的最大值
        int[] g = new int[n + 10];//从n - 1到i， 卖 - 买的最大值
        int minv = 0x3f3f3f3f;
        for(int i = 0;i < n;i ++) {
            if(i != 0) f[i] = f[i - 1];
            f[i] = Math.max(f[i], prices[i] - minv);    // 枚举第i天卖出和不卖出的最大值
            minv = Math.min(minv, prices[i]);
        }
        int maxv = -0x3f3f3f3f;
        for(int i = n - 1;i >= 0;i --) {
            if(i != n - 1) g[i] = g[i + 1];
            g[i] = Math.max(g[i], maxv - prices[i]);
            maxv = Math.max(maxv, prices[i]);
        }
        int res = 0;
        for(int i = 0;i < n;i ++) res = Math.max(res, f[i] + g[i]);
        return res;
    }
}
