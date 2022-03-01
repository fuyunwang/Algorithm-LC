package com.gopher.leetcode.types.tree;

/**
 * @Title TreeNode
 * @Author fyw
 * @Date 2022/1/20 21:05
 * @Description:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
