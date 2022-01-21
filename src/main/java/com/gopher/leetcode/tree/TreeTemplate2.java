package com.gopher.leetcode.tree;

/**
 * @Title TreeModel2
 * @Author fyw
 * @Date 2022/1/21 15:04
 * @Description: 二叉树的最大高度、最小高度、平衡二叉树
 */
public class TreeTemplate2 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
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
