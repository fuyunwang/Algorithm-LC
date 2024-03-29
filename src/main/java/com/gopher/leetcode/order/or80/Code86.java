package com.gopher.leetcode.order.or80;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code86
 * @Author fyw
 * @Date 2022/2/12 15:54
 * @Description: 分割链表
 */
public class Code86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left=new ListNode(-1);
        ListNode right=new ListNode(-1);
        ListNode ltail=left, rtail=right;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x){
                ltail.next=cur;
                cur=cur.next;       // 注意cur一定在这个位置，否则下面next置空之后就找不到接下来的节点了
                ltail=ltail.next;
                ltail.next=null;
            }else{
                rtail.next=cur;
                cur=cur.next;
                rtail=rtail.next;
                rtail.next=null;
            }
        }
        ltail.next=right.next;
        return left.next;
    }
}
