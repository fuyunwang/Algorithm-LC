package com.gopher.leetcode.order.or100;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code92
 * @Author fyw
 * @Date 2022/2/3 14:12
 * @Description: 反转链表II，反转部分链表。高频题目
 *
 */
public class Code92 {
    // 头插法，定义g为要反转的第一个结点的前一个结点，p为第一个结点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode g=dummyHead;
        ListNode p=dummyHead.next;
        for (int i = 0; i < left-1; i++) {
            g=g.next;
            p=p.next;
        }
        for (int i = 0; i < right-left; i++) {
            ListNode temp=p.next;
            p.next=p.next.next;

            temp.next=g.next;
            g.next=temp;
        }
        return dummyHead.next;
    }

}
