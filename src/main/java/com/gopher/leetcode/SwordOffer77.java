package com.gopher.leetcode;

import com.gopher.leetcode.linkedlist.ListNode;

/**
 * @Title SwordOffer77
 * @Author fyw
 * @Date 2022/2/3 15:03
 * @Description:
 */
public class SwordOffer77 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode fast=head,slow=head,prev=head;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return merge(l1,l2);
    }
    ListNode merge(ListNode l1, ListNode l2){
        ListNode p=new ListNode(-1);
        ListNode l=p;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1!=null){
            p.next=l1;
        }
        if(l2!=null){
            p.next=l2;
        }
        return l.next;
    }
}
