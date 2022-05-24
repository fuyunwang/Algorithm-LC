package com.fuyunwang.bilibili.order;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code24
 * @Author fyw
 * @Date 2022/5/24 11:54
 * @Description:
 */
public class Code24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode p=dummyHead;
        while (p.next!=null&&p.next.next!=null){
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
