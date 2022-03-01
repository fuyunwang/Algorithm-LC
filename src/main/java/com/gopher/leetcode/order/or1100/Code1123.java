package com.gopher.leetcode.order.or1100;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code1123
 * @Author fyw
 * @Date 2022/2/4 13:46
 * @Description: 最深叶节点的最近公共祖先
 */
public class Code1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root==null)
            return null;
        final int left = getDepth(root.left);
        final int right = getDepth(root.right);
        if (left==right)
            return root;
        if (left>right)
            return lcaDeepestLeaves(root.left);
        return lcaDeepestLeaves(root.right);
    }
    public int getDepth(TreeNode root){
        if (root==null)
            return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
