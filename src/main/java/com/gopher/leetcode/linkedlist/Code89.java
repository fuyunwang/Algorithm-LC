package com.gopher.leetcode.linkedlist;

/**
 * @Title Code89
 * @Author fyw
 * @Date 2022/2/7 12:14
 * @Description:
 * 删除节点但是不能用从头开始遍历的方法。脑筋急转弯就是将下一个节点的值复制到当前节点
 */
public class Code89 {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
