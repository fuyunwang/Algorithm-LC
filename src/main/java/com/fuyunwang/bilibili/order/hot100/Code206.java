package com.fuyunwang.bilibili.order.hot100;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code206
 * @Author fyw
 * @Date 2022/5/22 22:00
 * @Description:
 */
public class Code206 {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode cur=head;
        ListNode pre=null;
        ListNode next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode node=reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
