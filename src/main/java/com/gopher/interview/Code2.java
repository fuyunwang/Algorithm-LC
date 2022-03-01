package com.gopher.interview;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code2
 * @Author fyw
 * @Date 2022/1/30 12:42
 * @Description: 链表快排
 */
public class Code2 {

    ListNode quickSort(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode left=new ListNode(-1), mid=new ListNode(-1), right=new ListNode(-1);
        ListNode ltail=left,mtail=mid,rtail=right;
        // 处理三个链表
        int val=head.val;
        for (ListNode cur=head;cur!=null;cur=cur.next){
            if (cur.val<val) ltail=ltail.next=cur;
            else if (cur.val==val) mtail=mtail.next=cur;
            else rtail=rtail.next=cur;
        }
        ltail.next=mtail.next=rtail.next=null;
        // 递归处理链表
        left.next=quickSort(left.next);
        right.next=quickSort(right.next);
        //拼接三个链表
        getTail(left).next=mid.next;
        getTail(left).next=right.next;
        return left.next;
    }

    ListNode getTail(ListNode head){
        while (head.next!=null)
            head=head.next;
        return head;
    }
}
