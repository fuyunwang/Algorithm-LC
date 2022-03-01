package com.gopher.leetcode.types.linkedlist;

/**
 * @Title SwoardOffer24
 * @Author fyw
 * @Date 2022/1/25 12:51
 * @Description: 反转链表 Code206
 */
public class SwordOffer24 {
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
}
