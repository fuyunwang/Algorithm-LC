package com.gopher.leetcode.order.or1100;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code1721
 * @Author fyw
 * @Date 2022/2/13 22:07
 * @Description: 交换正数第K和倒数第K结点
 */
public class Code1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode fast=dummyHead;
        ListNode slow=dummyHead;
        // 找第K-1
        ListNode curK=dummyHead;
        for (int i = 0; i < k-1; i++) {
            curK=curK.next;
        }
        // 找倒数第K
        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode k1=curK.next;// 正数
        ListNode k2=slow.next;// 倒数
        // 如果正数和倒数一样直接返回
        if (k1==k2)
            return dummyHead.next;
        if (k1==k2.next){       // 注意环
            ListNode k1next=k1.next;
            k2.next=k1next;
            k1.next=k2;
            slow.next=k1;
            return dummyHead.next;
        }
        if (k2==k1.next){
            ListNode k2next=k2.next;
            k1.next=k2next;
            k2.next=k1;
            curK.next=k2;
            return dummyHead.next;
        }
        ListNode k1next=k1.next;
        ListNode k2next=k2.next;
        k1.next=k2next;
        k2.next=k1next;
        slow.next=k1;
        curK.next=k2;
        return dummyHead.next;
    }
}
