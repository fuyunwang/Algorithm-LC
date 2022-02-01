package com.gopher.leetcode;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code236
 * @Author fyw
 * @Date 2022/2/1 21:06
 * @Description: 二叉树的最近公共祖先
 */
public class Code236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null){
            return null;
        }
        if (p==root||q==root)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null&&right!=null){
            return root;
        }
        if (left==null&&right==null){
            return null;
        }
        return left==null?right:left;
    }
}
