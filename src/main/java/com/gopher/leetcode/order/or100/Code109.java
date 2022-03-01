package com.gopher.leetcode.order.or100;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;
import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code109
 * @Author fyw
 * @Date 2022/2/1 13:26
 * @Description: 有序链表转二叉树
 */
public class Code109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return new TreeNode(head.val);
        ListNode first=head;
        ListNode cur=head;
        ListNode pre=null;
        while (head!=null&&head.next!=null){
            pre=cur;
            head=head.next.next;
            cur=cur.next;
        }
        pre.next=null; //从中间断开
        TreeNode root=new TreeNode(cur.val);
        root.left=sortedListToBST(first);
        root.right=sortedListToBST(cur.next);
        return root;
    }

}
