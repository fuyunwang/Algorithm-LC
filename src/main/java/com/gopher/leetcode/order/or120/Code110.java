package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code110
 * @Author fyw
 * @Date 2022/2/1 13:21
 * @Description:
 */
public class Code110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(getHeight(root.left)-getHeight(root.right))<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
}
