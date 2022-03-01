package com.gopher.leetcode.types.structure.tree.normal;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code111
 * @Author fyw
 * @Date 2022/1/26 21:31
 * @Description: 二叉树的最小深度
 */
public class Code111 {
    // DP的思想，递推的考虑。注意题目要求叶子节点的最小深度
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        if (root.left==null&&root.right==null)
            return 1;
        if (root.left!=null&&root.right!=null)
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        if (root.left!=null)
            return minDepth(root.left)+1;
        return minDepth(root.right)+1;
    }
}
