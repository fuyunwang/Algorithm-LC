package com.gopher.swordoffer;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title SwordOffer22
 * @Author fyw
 * @Date 2022/2/3 20:32
 * @Description: 链表的倒数第K个节点
 */
public class SwordOffer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 首先来到正数第K个节点
        ListNode fast=head;
        for (int i = 0; i < k-1; i++) {
            fast=fast.next;
        }
        // 接着声明慢指针和快指针一起运作
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
