package com.gopher.leetcode.order.or80;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code83
 * @Author fyw
 * @Date 2022/2/9 14:02
 * @Description: 对于已经有序的排序链表，删除其中的重复元素直至每个元素只出现一次
 * 排序链表的思路考虑当前值是否与前一个值相等，不相等则是第一个不同的元素，需要保留
 */
public class Code83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        ListNode cur=head;
        for (ListNode p=cur.next;p!=null;p=p.next){
            if (p.val!=cur.val){
                cur=cur.next=p;
            }
        }
        cur.next=null;
        return head;
    }
}
