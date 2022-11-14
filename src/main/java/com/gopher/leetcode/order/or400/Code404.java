package com.gopher.leetcode.order.or400;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code404
 * @Author fyw
 * @Date 2022/11/14 21:37
 * @Description
 */
public class Code404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if (root==null)
            return 0;
        int res=0;
        if (root.left!=null&&root.left.left==null&&root.left.right==null){
            res+=root.left.val;
        }
        res+=dfs(root.left);
        res+=dfs(root.right);
        return res;
    }
}
