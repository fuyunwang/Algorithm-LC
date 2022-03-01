package com.gopher.interview;

/**
 * @Title Code42
 * @Author fyw
 * @Date 2022-02-22 11:03
 * @Description 复杂链表的复刻
 */
public class Code42 {
    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        ListNode now = head;
        while (now != null) {
            ListNode copyNode = new ListNode(now.val);
            copyNode.next = now.next;
            now.next = copyNode;
            now = copyNode.next;
        }
        now = head;
        while (now != null) {
            if (now.random != null) now.next.random = now.random.next;
            now = now.next.next;
        }

        ListNode res = head.next;
        now = head;
        ListNode next = now.next;
        while (next != null) {
            now.next = next.next;
            now = next;
            next = next.next;
        }
        return res;
    }

    class ListNode {
        int val;
        ListNode next, random;

        ListNode(int x) {
            this.val = x;
        }
    }

    ;
}