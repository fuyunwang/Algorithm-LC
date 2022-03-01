package com.gopher.leetcode.order.or400;

import com.gopher.leetcode.types.tree.TreeNode;

/**
 * @Title Code450
 * @Author fyw
 * @Date 2022/2/8 21:10
 * @Description: 删除二叉搜索树中的节点
 */
public class Code450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)
            return null;
        if (key<root.val)  root.left = deleteNode(root.left, key);
        else if (key>root.val) root.right=deleteNode(root.right,key);
        else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode r = root.right;
            while (r.left != null) {
                r = r.left;
            }
            r.left = root.left;
            return root.right;
        }
        return root;
    }
}
