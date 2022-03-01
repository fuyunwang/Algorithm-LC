package com.gopher.swordoffer;

import com.gopher.leetcode.types.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * @Title SwordOffer78
 * @Author fyw
 * @Date 2022/2/3 15:04
 * @Description:
 */
public class SwordOffer78 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<>((x,y)->x.val-y.val);
        for (ListNode head: lists) {
            if(head!=null)
                queue.offer(head);
        }
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        while (!queue.isEmpty()){
            final ListNode poll = queue.poll();
            if (poll.next!=null)
                queue.offer(poll.next);
            poll.next=null;
            cur.next=poll;
            cur=cur.next;
        }
        return dummyHead.next;
    }
}
