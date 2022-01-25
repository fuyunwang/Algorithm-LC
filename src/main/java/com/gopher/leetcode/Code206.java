package com.gopher.leetcode;

import com.gopher.leetcode.linkedlist.ListNode;

import java.util.List;

/**
 * @Title Code206
 * @Author fyw
 * @Date 2022/1/25 12:53
 * @Description:
 */
public class Code206 {
    public ListNode reverseList(ListNode head) {
        ListNode temp=null;
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            pre=cur;
            cur=cur.next;
            pre.next=temp;
            temp=pre;
        }
        return pre;
    }
    // 递归
    public ListNode reverseListRecur(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseListRecur(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
