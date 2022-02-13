package com.gopher.leetcode.order.or120;

/**
 * @Title Code116
 * @Author fyw
 * @Date 2022/2/9 13:54
 * @Description: 填充每个节点的下一个右侧节点指针
 * 宽搜
 */
public class Code116 {
    public Node connect(Node root) {
        if (root==null)
            return null;
        Node source=root;
        while (root.left!=null){
            for (Node p=root;p!=null;p=p.next){ // 类似广搜进行同层的搜索
                p.left.next=p.right;    // 同一个节点的子节点之间
                if (p.next!=null)       // 找到同一层下一个节点，当前节点的右孩子为同层节点的左孩子
                    p.right.next=p.next.left;
            }
            root=root.left;
        }
        return source;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
