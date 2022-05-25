package com.fuyunwang.bilibili.order.subarr;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title Code918
 * @Author fyw
 * @Date 2022-05-25 9:08
 * @Description 环形子数组的最大和
 */
public class Code918 {
    /**
     * 前缀和+单调队列求滑动窗口内最小值
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int[] sum=new int[2*n+1];
        for (int i = 1; i <= 2*n; i++) {
            sum[i]=sum[i-1]+nums[(i-1)%n];
        }
        int res=Integer.MIN_VALUE;
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i <= 2*n; i++) {
            if (!deque.isEmpty()&&i-deque.peekFirst()>n)
                deque.pollFirst();
            res=Math.max(res,sum[i]-sum[deque.peekFirst()]);
            while (!deque.isEmpty()&&sum[i]<=sum[deque.peekLast()])
                deque.pollLast();
            deque.addLast(i);
        }
        return res;
    }
}
