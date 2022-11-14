package com.gopher.leetcode.order.or1100;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code1325
 * @Author fyw
 * @Date 2022/11/14 21:24
 * @Description 删除给定值的叶子节点
 * 类似Code404
 */
public class Code1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root==null)
            return null;
        root.left=removeLeafNodes(root.left,target);
        root.right=removeLeafNodes(root.right,target);
        if (root.left==null&&root.right==null&&root.val==target)
            return null;
        return root;
    }
}
