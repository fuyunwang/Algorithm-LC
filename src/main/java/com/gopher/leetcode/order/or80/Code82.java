package com.gopher.leetcode.order.or80;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code82
 * @Author fyw
 * @Date 2022/2/9 12:38
 * @Description: 删除链表中的重复元素II
 * 删除链表中所有有重复元素的节点，使其一个都不存在
 */
public class Code82 {
    // 快慢指针解决
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode slow=dummyHead;
        while (slow.next!=null){
            ListNode fast=slow.next.next;
            while (fast!=null&&fast.val==slow.next.val) fast=fast.next;//找到不重复的fast
            if (slow.next.next==fast) slow=slow.next;//说明此时第二个结点不是重复元素节点
            else
                slow.next=fast;
        }
        return dummyHead.next;
    }
}
