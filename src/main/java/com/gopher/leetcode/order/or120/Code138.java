package com.gopher.leetcode.order.or120;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code138
 * @Author fyw
 * @Date 2022/2/13 14:03
 * @Description: 复制带有随机指针的链表
 * 哈希表存储
 */
public class Code138 {
    Map<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        Node cur=head;
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        Node res=null;
        while (cur!=null){
            final Node node = map.get(cur);
            if (res==null)
                res=node;
            node.next=map.get(cur.next);
            node.random=map.get(cur.random);
            cur=cur.next;
        }
        return res;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
