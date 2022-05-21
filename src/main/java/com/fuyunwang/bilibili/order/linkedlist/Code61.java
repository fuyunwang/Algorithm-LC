package com.fuyunwang.bilibili.order.linkedlist;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;

/**
 * @Title Code61
 * @Author fyw
 * @Date 2022/5/21 16:51
 * @Description: 旋转链表
 */
public class Code61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null)
            return null;
        // k可能很大所以先对链表长度取模，记录下尾结点方便操作
        ListNode tail=null;
        int len=0;
        for (ListNode p=head;p!=null;p=p.next){
            tail=p;
            len++;
        }
        k%=len;
        // 后面的k个节点移到前面，也就是前面n-k个节点不动，也就是要移动n-k-1次
        ListNode p=head;
        for (int i = 0; i < len-k-1; i++) {
            p=p.next;
        }
        //拼接首先记录第n-k+1个点
        ListNode temp=p.next;
        // 尾结点放到开头
        tail.next=head;
        // 下一个节点置空
        p.next=null;
        return temp;
    }
}
