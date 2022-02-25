package com.gopher.leetcode.order.or400;

/**
 * @Title Code441
 * @Author fyw
 * @Date 2022/2/9 14:07
 * @Description: 排列硬币
 */
public class Code441 {
    public int arrangeCoins(int n) {
        int k=0;
        while(n>=k) n-=k++;
        return k==0?0:k-1;
    }
}
