package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code143
 * @Author fyw
 * @Date 2022/2/8 21:26
 * @Description: 重排链表
 * 两个链表交错相排序
 */
public class Code143 {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null)
            return;
        // 环或者找链表中点
        ListNode fast=head.next.next,slow=head.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        // 记录后半段链表
        ListNode head2=slow.next;
        slow.next=null;
        head2=reverseList(head2);
        // 将两个链表进行拼接
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        while (head!=null||head2!=null){
            if (head!=null){
                cur.next=head;
                cur=cur.next;
                head=head.next;
            }
            if (head2!=null){
                cur.next=head2;
                cur=cur.next;
                head2=head2.next;
            }
        }
    }

    ListNode reverseList(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode node=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
}
