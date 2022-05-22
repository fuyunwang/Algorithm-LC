package com.fuyunwang.bilibili.order.hot100;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code160
 * @Author fyw
 * @Date 2022/5/22 21:08
 * @Description:
 */
public class Code160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null&&headB==null)
            return null;
        ListNode cur1=headA;
        ListNode cur2=headB;
        while (cur1!=cur2){
            cur1=cur1==null?headB:cur1.next;
            cur2=cur2==null?headA:cur2.next;
        }
        return cur1;
    }
}
