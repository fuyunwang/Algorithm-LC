package com.fuyunwang.bilibili.order;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code25
 * @Author fyw
 * @Date 2022/5/24 15:23
 * @Description:
 */
public class Code25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode p=dummyHead;
        while (true){
            ListNode q=p;
            for (int i = 0; i < k&&q!=null; i++) {
                q=q.next;
            }
            if (q==null) {  // 此时已经不足k个节点不需要翻转直接结束
                break;
            }
            ListNode a=p.next;
            ListNode b=a.next;
            for (int i = 0; i < k-1; i++) {
                ListNode c=b.next;
                b.next=a;
                a=b;
                b=c;
            }
            ListNode first=p.next;
            p.next=a;
            first.next=b;
            p=first;
        }
        return dummyHead.next;
    }
}
