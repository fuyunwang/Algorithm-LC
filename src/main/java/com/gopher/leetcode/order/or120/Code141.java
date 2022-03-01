package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code141
 * @Author fyw
 * @Date 2022/2/9 12:34
 * @Description: 环形链表
 */
public class Code141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
