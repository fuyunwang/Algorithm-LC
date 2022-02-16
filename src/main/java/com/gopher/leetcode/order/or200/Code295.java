package com.gopher.leetcode.order.or200;

import java.util.PriorityQueue;

/**
 * @Title Code295
 * @Author fyw
 * @Date 2022/2/8 22:04
 * @Description: 数据流中的中位数
 */
public class Code295 {
    class MedianFinder {
        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;
        public MedianFinder() {
            minQueue=new PriorityQueue<>(); // 小根堆放后面较大的数据
            maxQueue=new PriorityQueue<>((a,b)->b-a);   // 大根堆放前面较小的数据
        }

        public void addNum(int num) {
            // 先加入大根堆挑出最大的数据并加入小根堆
            // 然后根据大根堆和小根堆的数据量进行调整，始终保持小根堆的数据量小于大根堆的数据量
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
            while (minQueue.size()>maxQueue.size()){
                maxQueue.add(minQueue.poll());
            }
        }

        public double findMedian() {
            if (!maxQueue.isEmpty()){
                if (maxQueue.size()==minQueue.size()){
                    return (maxQueue.peek()+minQueue.peek())/2.0;
                }else{
                    return maxQueue.peek();
                }
            }
            return -1d;
        }
    }
}
