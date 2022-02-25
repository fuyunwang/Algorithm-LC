package com.gopher.leetcode.order.or900;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Title Code918
 * @Author fyw
 * @Date 2022/2/9 14:49
 * @Description: 环形子数组的最大和
 * 破环成链，前缀和，滑动窗口
 */
public class Code918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length ;
        int [] tmp = new int [2 * n] ;
        for (int i = 0; i < n ; ++i) {
            tmp[i] = nums[i] ;
            tmp[i + n] = nums[i] ;
        }
        int [] sum = new int [tmp.length + 1] ;
        for (int i = 1 ; i <= 2 * n ; ++i) {
            sum[i] = sum[i - 1] + tmp[i - 1] ;
        }
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(0) ;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 2 * n ; ++i) {
            while (!dq.isEmpty() && i - dq.peekFirst() > n) dq.pollFirst();
            max = Math.max(max, sum[i] - sum[dq.peekFirst()])  ;
            while (!dq.isEmpty() && sum[i] <= sum[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i) ;
        }
        return max ;
    }
}
