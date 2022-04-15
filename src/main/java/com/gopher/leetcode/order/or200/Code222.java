package com.gopher.leetcode.order.or200;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code222
 * @Author fyw
 * @Date 2022/4/15 15:15
 * @Description: 完全二叉树的节点个数
 */
public class Code222 {
    /**
     * 满二叉树的节点个数可以通过公式直接计算得到
     * 完全二叉树的节点个数：
     * 1. 左右子树都是满二叉树，满二叉树直接计算
     * 2. 至少有一棵子树不是满二叉树，满二叉树直接计算、否则直接递归
     */
    public int countNodes(TreeNode root) {
        if (root==null)
            return 0;
        int x=1;
        int y=1;
        TreeNode left=root.left;
        TreeNode right=root.right;
        while (left!=null){
            x++;
            left=left.left;
        }
        while (right!=null){
            y++;
            right=right.right;
        }
        if (x==y)
            return (1<<x)-1;    // 满二叉树直接返回 2的x次方减一
        return countNodes(root.left)+1+countNodes(root.right);
    }
}
