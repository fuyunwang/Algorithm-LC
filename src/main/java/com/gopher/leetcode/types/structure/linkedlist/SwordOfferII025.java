package com.gopher.leetcode.types.structure.linkedlist;

/**
 * @Title SwordOfferII025
 * @Author fyw
 * @Date 2022/1/25 13:01
 * @Description:
 */
public class SwordOfferII025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode dummy=new ListNode(-1);
        int temp=0;
        ListNode cur=dummy;
        while(l1!=null||l2!=null||temp!=0){
            int val1=l1==null?0:l1.val;
            int val2=l2==null?0:l2.val;
            temp+=(val1+val2);
            cur.next=new ListNode(temp%10);
            temp/=10;
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        return reverseList(dummy.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
