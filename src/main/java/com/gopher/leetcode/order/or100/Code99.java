package com.gopher.leetcode.order.or100;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code99
 * @Author fyw
 * @Date 2022/2/1 14:34
 * @Description: 恢复二叉搜索树，类似Code98判断是否是合法的二叉树
 */
public class Code99 {
    TreeNode t1,t2,pre=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        Integer temp=t1.val;
        t1.val=t2.val;
        t2.val=temp;
    }
    void inorder(TreeNode root){
        if (root==null)
            return;
        inorder(root.left);
        if (pre!=null&&pre.val>root.val){
            if (t1==null) t1=pre;
            t2=root;
        }
        pre=root;
        inorder(root.right);
    }
}
