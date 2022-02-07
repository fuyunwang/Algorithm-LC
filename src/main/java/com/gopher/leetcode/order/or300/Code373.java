package com.gopher.leetcode.order.or300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Title Code373
 * @Author fyw
 * @Date 2022/2/3 16:46
 * @Description: 查找和最小的 K 对数字；多路归并,多个数组进行merge
 * 类似题目还有 Code264 313 632 719 786 1439 1508 1675
 */
public class Code373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Node> queue=new PriorityQueue<>(((o1, o2) -> (o2.fir+ o2.sec)-(o1.fir+ o1.sec)));
        for (int i = 0; i < Math.min(k,nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                queue.add(new Node(nums1[i],nums2[j]));
                if (queue.size()>k)
                    queue.poll();
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        while (!queue.isEmpty()){
            final Node poll = queue.poll();
            res.add(new ArrayList<>(Arrays.asList(poll.fir,poll.sec)));
        }
        return res;
    }
    class Node{
        int fir;
        int sec;

        public Node(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}
