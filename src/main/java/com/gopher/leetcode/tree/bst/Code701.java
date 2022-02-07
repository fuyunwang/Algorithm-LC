package com.gopher.leetcode.tree.bst;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code701
 * @Author fyw
 * @Date 2022/2/7 18:06
 * @Description:
 * 二叉搜索树插入节点
 */
public class Code701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
