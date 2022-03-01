package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code112
 * @Author fyw
 * @Date 2022/1/26 21:33
 * @Description:
 */
public class Code112 {
    // 定义记录从根节点到具体某一节点的路径之和函数，逆向考虑减去当前数看看满足是否为0
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        targetSum-=root.val;
        if (root.left==null&&root.right==null) return targetSum==0;
        return root.left != null && hasPathSum(root.left, targetSum) || root.right != null && hasPathSum(root.right, targetSum);
    }


}
