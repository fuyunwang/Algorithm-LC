package com.gopher.leetcode.types.tree.normal;

import com.gopher.leetcode.types.tree.TreeNode;

/**
 * @Title Code404
 * @Author fyw
 * @Date 2022/2/8 13:00
 * @Description: 左叶子之和
 */
public class Code404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null)
            return 0;
        if (root.left!=null&&root.left.left==null&&root.left.right==null)
            return root.left.val+sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
}
