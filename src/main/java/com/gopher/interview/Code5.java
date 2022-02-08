package com.gopher.interview;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title Code5
 * @Author fyw
 * @Date 2022/2/8 17:27
 * @Description: 递归和迭代反转链表
 */
public class Code5 {
    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode a=head,b=head.next,c=null;
        while(b!=null){
            c=b.next;
            b.next=a;
            a=b;
            b=c;
        }
        head.next=null;
        return a;
    }
    // 递归
    public ListNode reverseList(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node; // 返回的是最尾的节点也是整个链表的最尾节点
    }
}
