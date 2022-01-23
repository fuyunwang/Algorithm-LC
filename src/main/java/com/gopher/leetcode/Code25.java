package com.gopher.leetcode;

/**
 * @Title Code25
 * @Author fyw
 * @Date 2022/1/23 17:12
 * @Description: 经典题目，k个一组交换链表中的结点
 */
public class Code25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        for (ListNode p=dummy;;){
            // 首先检查下后面是否足k个元素，不足直接跳出循环不需要改变
            ListNode valid=p;
            for (int i = 0; i < k&&valid!=null; i++) {
                valid=valid.next;
            }
            if (valid==null){
                break;
            }
            // 足k个进行操作，先将k个一组的内部进行变换，方式是利用双指针
            ListNode a=p.next;ListNode b=a.next;
            for (int i = 0; i < k-1; i++) {
                ListNode c = b.next;
                b.next=a;
                a=b;
                b=c;
            }
            // 组与组之间进行改变
            ListNode c=p.next;
            p.next=a;
            c.next=b;
            p=c;
        }
        return dummy.next;
    }
}
