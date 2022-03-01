package com.gopher.leetcode.types.tree;

/**
 * @Title TreeTemplate7
 * @Author fyw
 * @Date 2022/2/7 20:18
 * @Description: 填充每个节点的下一个右侧节点
 */
public class TreeTemplate7 {

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

    }
}
