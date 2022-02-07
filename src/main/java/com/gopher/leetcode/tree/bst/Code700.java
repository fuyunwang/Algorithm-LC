package com.gopher.leetcode.tree.bst;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code700
 * @Author fyw
 * @Date 2022/2/7 17:58
 * @Description:
 * 二叉搜索树查询节点
 */
public class Code700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
            return null;
        if (root.val==val)
            return root;
        if (root.val<val)
            return searchBST(root.right,val);
        return searchBST(root.left,val);
    }
}
