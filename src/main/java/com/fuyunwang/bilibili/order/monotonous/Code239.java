package com.fuyunwang.bilibili.order.monotonous;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Title Code239
 * @Author fyw
 * @Date 2022-05-25 10:10
 * @Description 滑动窗口最大值
 */
public class Code239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty()&&i-deque.peekFirst()+1>k)
                deque.pollFirst();
            while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i])
                deque.pollLast();
            deque.addLast(i);
            if (i>=k-1)
                res.add(nums[deque.peekFirst()]);
        }
        int[] arr=new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i]=res.get(i);
        }
        return arr;
    }
}
