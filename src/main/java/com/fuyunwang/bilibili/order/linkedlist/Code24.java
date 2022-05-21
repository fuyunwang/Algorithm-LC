package com.fuyunwang.bilibili.order.linkedlist;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code24
 * @Author fyw
 * @Date 2022/5/21 16:02
 * @Description:
 */
public class Code24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        for (ListNode p=dummyHead;p.next!=null&&p.next.next!=null;){
            ListNode a=p.next;
            ListNode b=a.next;
            a.next=b.next;
            p.next=b;
            b.next=a;
            p=a;
        }
        return dummyHead.next;
    }
}
