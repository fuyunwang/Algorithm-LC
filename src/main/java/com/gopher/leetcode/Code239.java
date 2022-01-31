package com.gopher.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code239
 * @Author fyw
 * @Date 2022/1/31 16:31
 * @Description: 滑动窗口最大值，单调队列
 */
public class Code239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return new int[]{};
        LinkedList<Integer> queue=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]) queue.pollLast();
            queue.addLast(i);
        }
        res.add(nums[queue.peekFirst()]);
        for (int i=k;i<nums.length;i++){
            if (queue.peekFirst()<=i-k)
                queue.pollFirst();
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]) queue.pollLast();
            queue.addLast(i);
            res.add(nums[queue.peekFirst()]);
        }
        int[] arr=new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i]=res.get(i);
        }
        return arr;
    }
}
