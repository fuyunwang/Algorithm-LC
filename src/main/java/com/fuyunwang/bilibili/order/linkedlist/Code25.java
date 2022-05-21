package com.fuyunwang.bilibili.order.linkedlist;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code25
 * @Author fyw
 * @Date 2022/5/21 16:14
 * @Description:
 */
public class Code25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        for (ListNode p=dummyHead;;){
            ListNode q=p;
            for (int i = 0; i < k&&q!=null; i++) {
                q=q.next;
            }
            if (q==null){
                break;
            }
            ListNode a=p.next,b=a.next;
            for (int i = 0; i < k-1; i++) {
                ListNode c=b.next;
                b.next=a;
                a=b;
                b=c;
            }
            ListNode c=p.next;
            c.next=b;   // 下一轮的首节点要拼接到第一轮的后面
            p.next=a;   // 最后一个节点，也是下一轮的前一个结点
            p=c;
        }
        return dummyHead.next;
    }
}
