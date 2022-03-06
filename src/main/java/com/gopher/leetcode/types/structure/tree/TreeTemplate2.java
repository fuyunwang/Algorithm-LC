package com.gopher.leetcode.types.structure.tree;

/**
 * @Title TreeModel2
 * @Author fyw
 * @Date 2022/1/21 15:04
 * @Description: 二叉树的修改
 */
public class TreeTemplate2 {
    // 根到叶路径上的不足节点
    static class Code1080{
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root==null)
                return null;
            if (root.left==null&& root.right==null){
                return root.val<limit?null:root;
            }
            root.left=sufficientSubset(root.left,limit-root.val);
            root.right=sufficientSubset(root.right,limit-root.val);
            return root.left==root.right?null:root;
        }
    }
}
