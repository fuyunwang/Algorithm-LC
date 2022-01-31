package com.gopher.leetcode;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title Code160
 * @Author fyw
 * @Date 2022/1/31 17:22
 * @Description: 链表相交
 */
public class Code160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null)
            return null;
        if (headA==headB)
            return headA;
        ListNode curA=headA;
        ListNode curB=headB;
        while (curA!=curB){
            curA=curA==null?headB:curA.next;
            curB=curB==null?headA:curB.next;
        }
        return curA;
    }
}
