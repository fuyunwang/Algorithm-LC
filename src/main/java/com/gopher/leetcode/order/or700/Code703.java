package com.gopher.leetcode.order.or700;

import java.util.PriorityQueue;

/**
 * @Title Code703
 * @Author fyw
 * @Date 2022/2/1 9:05
 * @Description: 数据流最大值
 */
public class Code703 {
    PriorityQueue<Integer> queue;
    int k;
    public Code703(int k, int[] nums) {
        this.k=k;
        queue=new PriorityQueue<>((x,y)->x-y);
        for (int i = 0; i < nums.length; i++) {
            this.add(nums[i]);
        }
    }

    public int add(int val) {
        if (queue.size()<k){
            queue.offer(val);
        }else{
            if (queue.peek()<val){
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }
}
