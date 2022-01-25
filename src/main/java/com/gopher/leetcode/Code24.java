package com.gopher.leetcode;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title Code24
 * @Author fyw
 * @Date 2022/1/23 15:49
 * @Description: 经典题目，两两交换链表中的结点
 */
public class Code24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        for (ListNode temp=dummy;temp.next!=null&&temp.next.next!=null;){
            ListNode a=temp.next;
            ListNode b=a.next;
            temp.next=b; // 头结点指向第二个结点
            a.next=b.next; // 第一个结点指向第三个结点
            b.next=a;      // 第二个结点指向第一个结点
            temp=a;     // 更新指针为第一个结点
        }
        return dummy.next;
    }
}
