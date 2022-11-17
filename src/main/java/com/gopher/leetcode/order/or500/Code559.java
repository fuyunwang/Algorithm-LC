package com.gopher.leetcode.order.or500;

import java.util.List;

/**
 * @Title Code559
 * @Author fyw
 * @Date 2022/11/17 20:40
 * @Description N叉树的最大深度
 */
public class Code559 {
    public int maxDepth(Node root) {
        if (root==null)
            return 0;
        int res=0;
        for (Node child:root.children){
            res=Math.max(maxDepth(child),res);
        }
        return res+1;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};