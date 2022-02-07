package com.gopher.leetcode.order.or800;

import java.util.LinkedList;

/**
 * @Title Code862
 * @Author fyw
 * @Date 2022/1/31 18:04
 * @Description: 和至少为K的最短子数组，前缀和+单调队列。单调队列尾加头取
 */
public class Code862 {
    public int shortestSubarray(int[] nums, int k) {
        int len=nums.length;
        long[] sum=new long[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + (long)nums[i];
        }

        int res=len+1;
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i = 0; i < sum.length; i++) {
            while (!queue.isEmpty()&&sum[queue.peekLast()]>=sum[i]) queue.pollLast();
            while (!queue.isEmpty()&&sum[i]-sum[queue.peekFirst()]>=k){
                res=Math.min(res,i-queue.pollFirst());
            }
            queue.addLast(i);
        }
        return res==len+1?-1:res;
    }
}
