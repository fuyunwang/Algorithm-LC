package com.gopher.interview.prac;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title RingEntry
 * @Author fyw
 * @Date 2022-02-22 9:28
 * @Description 链表中环的入口节点
 * 慢指针走x+y步，快指针走了2x+2y+x步
 * 做法是快指针2步走慢指针1步走，相遇时，慢指针回到起点，快慢指针一起一步走。
 */
public class RingEntry {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (slow==fast){
                // 从相遇节点开始，另从头和相遇节点开始同步运行
                ListNode index1=head;
                ListNode index2=fast;
                while (index1!=index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
