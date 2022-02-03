package com.gopher.leetcode;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title SwordOffer21
 * @Author fyw
 * @Date 2022/2/3 20:49
 * @Description: 删除链表倒数第N个节点，类似22
 */
public class SwordOffer21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 首先来到正数第n个节点
        ListNode fast=head;
        ListNode prev=null;
        for (int i = 0; i < n-1; i++) {
            fast=fast.next;
        }
        // 来到倒数第N个节点
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            fast=fast.next;
            slow=slow.next;
        }
        // 处理边界条件
        if(fast==head){
            return null;
        }
        if(slow==head){
            return slow.next;
        }
        if(prev!=null){
            prev.next=slow.next;
        }
        return head;
    }
}
