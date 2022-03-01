package com.gopher.leetcode.types.linkedlist;

/**
 * @Title ListNode
 * @Author fyw
 * @Date 2022/1/20 19:54
 * @Description:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
