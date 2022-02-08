package com.gopher.leetcode.order.or400;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * @Title Code480
 * @Author fyw
 * @Date 2022/2/8 11:00
 * @Description: 滑动窗口中位数
 * 对顶堆解决
 */
public class Code480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxQueue=new PriorityQueue<>((a,b)-> Integer.compare(nums[b], nums[a]));
        PriorityQueue<Integer> minQueue=new PriorityQueue<>((a,b)-> Integer.compare(nums[a], nums[b]));
        double[] res=new double[nums.length-k+1];
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            maxQueue.remove(i-k);
            minQueue.remove(i-k);
            // 先往小根堆开始加
            minQueue.offer(i);
            maxQueue.offer(minQueue.poll());
            if (maxQueue.size()>minQueue.size())
                minQueue.offer(maxQueue.poll());
            if (i-k+1>=0){
                if (maxQueue.size()==minQueue.size()){
                    res[index++]=(nums[maxQueue.peek()]/2D+nums[minQueue.peek()]/2D);
                }else{
                    res[index++]=nums[minQueue.peek()];
                }
            }
        }
        return res;
    }
    // Java8写法
    public double[] medianSlidingWindow1(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed()), right = new TreeSet<>(comparator);
        Supplier<Double> median = () -> (k % 2 == 0) ? ((double) nums[left.first()] + nums[right.first()]) / 2 : (double) nums[right.first()];
        double[] ans = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) left.add(i);
        while (left.size() > right.size()) right.add(left.pollFirst());
        ans[0] = median.get();

        for (int i = k, idx = 1; i < nums.length; i++) {
            if (!left.remove(i - k)) right.remove(i - k);
            if (right.size() == 0 || comparator.compare(i, right.first()) >= 0) {
                right.add(i);
                if (right.size() > left.size() + 1) left.add(right.pollFirst());
            } else {
                left.add(i);
                if (left.size() > right.size()) right.add(left.pollFirst());
            }
            ans[idx++] = median.get();
        }
        return ans;
    }
}
