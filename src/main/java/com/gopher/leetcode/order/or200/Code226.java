package com.gopher.leetcode.order.or200;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code226
 * @Author fyw
 * @Date 2022/1/31 17:20
 * @Description: 翻转二叉树
 */
public class Code226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
