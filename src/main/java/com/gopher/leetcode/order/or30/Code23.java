package com.gopher.leetcode.order.or30;

import com.gopher.leetcode.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * @Title Code23
 * @Author fyw
 * @Date 2022/1/23 14:05
 * @Description: 合并K个有序链表
 */
public class Code23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>((x,y)->{ return x.val- y.val;});
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                queue.add(lists[i]);
            }
        }
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while (!queue.isEmpty()){
            final ListNode poll = queue.poll();
            cur.next=new ListNode(poll.val);
            cur=cur.next;
            ListNode next=poll.next;
            if (next!=null){
                queue.add(next);
            }
        }
        return head.next;
    }
}
