package com.gopher.leetcode.order.or700;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code725
 * @Author fyw
 * @Date 2022/2/9 13:58
 * @Description: 分隔链表
 */
public class Code725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        ListNode p = root;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        p = root;
        for (int i = 0; i < k; i++) {
            int len = n / k;
            if (i < n % k) {
                len++;
            }
            res[i] = p;
            for (int j = 0; j < len - 1; j++) {
                p = p.next;
            }
            if (p != null) {
                ListNode q = p.next;
                p.next = null;
                p = q;
            }
        }
        return res;
    }

}
