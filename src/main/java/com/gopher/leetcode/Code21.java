package com.gopher.leetcode;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title Code21
 * @Author fyw
 * @Date 2022/1/22 22:23
 * @Description: 合并两个有序链表
 */
public class Code21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1=list1;
        ListNode cur2=list2;
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while (cur1!=null&&cur2!=null){
            int val=cur1.val;
            if (val>cur2.val){
                val=cur2.val;
                cur2=cur2.next;
            }else{
                cur1=cur1.next;
            }
            cur.next=new ListNode(val);
            cur=cur.next;
        }
        while (cur1!=null){
            cur.next=new ListNode(cur1.val);
            cur=cur.next;
            cur1=cur1.next;
        }
        while (cur2!=null){
            cur.next=new ListNode(cur2.val);
            cur=cur.next;
            cur2=cur2.next;
        }
        return head.next;
    }
}
