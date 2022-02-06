package com.gopher.leetcode.order.or1000;

import java.util.PriorityQueue;

/**
 * @Title Code1046
 * @Author fyw
 * @Date 2022/2/6 16:35
 * @Description:
 * 每次选出最重的两个石头——>优先队列，堆
 */
public class Code1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((x,y)->y-x);
        for (int i:stones){
            queue.offer(i);
        }
        while (queue.size()>=2){
            final Integer poll1 = queue.poll();
            final Integer poll2 = queue.poll();
            if (poll1>poll2)
                queue.offer(poll1-poll2);
        }
        return queue.size()>0?queue.peek():0;
    }
}
