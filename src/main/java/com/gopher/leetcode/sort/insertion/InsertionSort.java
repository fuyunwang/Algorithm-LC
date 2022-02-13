package com.gopher.leetcode.sort.insertion;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title InsertionSort
 * @Author fyw
 * @Date 2022/2/13 13:14
 * @Description: 链表插入排序
 */
public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode pre=head;//标志已经排序的链表
        while (pre.next!=null){
            // 考虑后续每一个节点
            ListNode insert=pre.next;
            if (insert.val>= pre.val){
                pre=pre.next;
                continue;
            }
            ListNode cur=dummyHead;
            while (cur.next.val< insert.val)
                cur=cur.next;
            pre.next=insert.next;
            insert.next=cur.next;
            cur.next=insert;
        }
        return dummyHead.next;
    }
}
