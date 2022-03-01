package com.gopher.leetcode.swordoffer;

import com.gopher.leetcode.types.linkedlist.ListNode;

/**
 * @Title Code4
 * @Author fyw
 * @Date 2022-03-01 20:59
 * @Description
 */
public class Code4 {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode temp=null;
        ListNode pre=null;
        while (cur!=null){
            temp=cur;   // 第一步保存当前节点
            cur=cur.next; // 找到下一个节点
            temp.next=pre;// 当前节点的下一个指针换掉，注意循环恒等性pre初始值也是null
            pre=temp;     // pre变换当前节点
        }
        return pre;
    }
    static class Code4_2{
        public ListNode reverseList(ListNode head) {
            if (head==null||head.next==null){
                return head;// 返回最后一个节点
            }
            ListNode node=reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return node;// 返回最后一个节点，注意内部代码node始终不变
        }
    }
}
