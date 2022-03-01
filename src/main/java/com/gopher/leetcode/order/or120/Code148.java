package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code148
 * @Author fyw
 * @Date 2022/2/8 22:07
 * @Description: 排序链表
 * 归并排序的效率>插入排序>快速排序
 * 如何实现非递归的归并排序达到O(1)的空间复杂度
 */
public class Code148 {
    public ListNode dfs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode s=head,f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }

        int val=s.val;

        ListNode lt = new ListNode(-1);
        ListNode gt = new ListNode(-1);
        ListNode he = new ListNode(-1);

        ListNode lc = lt, gc = gt, hc = he, c = head;
        while(c != null) {
            if(c.val > val) {
                gc.next = c;
                gc = gc.next;
            } else if (c.val < val){
                lc.next = c;
                lc = lc.next;
            } else {
                hc.next = c;
                hc = hc.next;
            }

            c = c.next;
        }

        // 防止出现循环
        lc.next = null;
        gc.next = null;
        hc.next = null;

        ListNode ll = dfs(lt.next);
        ListNode gg = dfs(gt.next);

        if (ll != null){
            ListNode cc = ll;
            while(cc.next != null) {
                cc = cc.next;
            }

            cc.next = he.next;
            if (gg != null) {
                ListNode hh = he.next;
                while(hh.next != null) {
                    hh = hh.next;
                }

                hh.next = gg;
            }

            return ll;
        } else if (gg != null) {
            ListNode hh = he.next;
            while(hh.next != null) {
                hh = hh.next;
            }

            hh.next = gg;

            return he.next;
        }

        return head;
    }

    public ListNode sortList(ListNode head) {
        return dfs(head);
    }

}
