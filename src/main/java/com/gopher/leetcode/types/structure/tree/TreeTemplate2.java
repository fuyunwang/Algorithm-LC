package com.gopher.leetcode.types.structure.tree;

/**
 * @Title TreeModel2
 * @Author fyw
 * @Date 2022/1/21 15:04
 * @Description: 二叉树路径求和
 */
public class TreeTemplate2 {
    static class Code1080{

    }
    static class Code538{
        // 累加数之和其实就是逆着遍历然后累加
        int sum=0;
        public TreeNode bstToGst(TreeNode root) {
            if (root==null)
                return null;
            bstToGst(root.right);
            root.val+=sum;
            sum=root.val;
            bstToGst(root.left);
            return root;
        }
    }
}
