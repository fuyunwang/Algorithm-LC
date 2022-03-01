package com.gopher.leetcode.order.or300;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code328
 * @Author fyw
 * @Date 2022/2/8 21:58
 * @Description: 奇偶链表
 */
public class Code328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode j = head;
        ListNode p = head.next;
        ListNode o = p;

        while(j.next!=null && o.next!=null){
            j.next = o.next;
            j = j.next;
            o.next = j.next;
            o = o.next;
        }
        j.next = p;
        return head;
    }
}
