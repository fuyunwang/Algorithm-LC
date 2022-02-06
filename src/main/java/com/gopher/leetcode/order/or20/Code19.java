package com.gopher.leetcode.order.or20;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title Code19
 * @Author fyw
 * @Date 2022/1/22 22:14
 * @Description:
 */
public class Code19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp=new ListNode(-1);
        temp.next=head;
        ListNode cur=temp;
        while(cur.next!=null){
            count++;
            cur=cur.next;
        }
        cur=temp;
        for(int i=0;i<count-n;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return temp.next;
    }
}
