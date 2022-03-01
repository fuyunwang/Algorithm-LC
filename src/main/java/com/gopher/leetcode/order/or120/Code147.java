package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code147
 * @Author fyw
 * @Date 2022/2/9 13:57
 * @Description: 链表插入排序
 * 1、在 pre 维护的是从 [0,pre] 的位置链表都是排好序的
 * 2、insert 表示 pre 的下一个元素，
 *   1、若 insert.val >= pre.val，则可以知道从 [0,pre] 位置链表都是排好序的，更新pre
 *   2、若 insert.val < pre.val，则需要从前面[0,pre]的中把 insert 的元素插入进去，即通过 cur 找到第一个大于 insert.val 的元素，插入到该元素的前面
 */
public class Code147 {
    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode pre=head;//标志已经排序的链表
        while (pre.next!=null){
            // 考虑后续每一个节点
            ListNode insert=pre.next;
            if (insert.val>= pre.val){
                pre=pre.next;
                continue;
            }
            ListNode cur=dummyHead;
            while (cur.next.val< insert.val)
                cur=cur.next;
            pre.next=insert.next;
            insert.next=cur.next;
            cur.next=insert;
        }
        return dummyHead.next;
    }
}
