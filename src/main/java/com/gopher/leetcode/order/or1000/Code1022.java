package com.gopher.leetcode.order.or1000;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code1022
 * @Author fyw
 * @Date 2022/2/17 21:28
 * @Description: 从根到叶的二进制数之和
 * 一类问题
 */
public class Code1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int x) { // 返回以当前根节点的树的二进制之和
        if(root==null)
            return 0;
        x=x*2+root.val;
        if (root.left==null&&root.right==null) return x;
        int res=0;      // 注意求子树节点的过程
        if (root.left!=null)
            res+=dfs(root.left,x);
        if (root.right!=null);
            res+=dfs(root.right,x);
        return res;
    }
}
