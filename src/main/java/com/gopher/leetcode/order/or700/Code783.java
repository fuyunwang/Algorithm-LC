package com.gopher.leetcode.order.or700;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code783
 * @Author fyw
 * @Date 2022/2/18 17:45
 * @Description: 二叉搜索树节点最小距离
 */
public class Code783 {
    int res=Integer.MAX_VALUE;
    boolean isFirst=true;
    int last=0;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }
    void dfs(TreeNode root){
        if (root==null)
            return;
        dfs(root.left);
        if (isFirst){
            isFirst=false;
            last=root.val;
        }else{
            res=Math.min(res,root.val-last);
            last=root.val;
        }
        dfs(root.right);
    }
}
