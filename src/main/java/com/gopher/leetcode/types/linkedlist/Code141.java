package com.gopher.leetcode.types.linkedlist;

/**
 * @Title Code141
 * @Author fyw
 * @Date 2022/2/6 19:50
 * @Description: 判断是否有环返回真假
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
