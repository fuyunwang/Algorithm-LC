package com.gopher.leetcode;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code230
 * @Author fyw
 * @Date 2022/1/31 17:16
 * @Description: 与98题一样的二叉搜索树中序遍历求某一条件的模板一致
 */
public class Code230 {
    int res=0;
    int cur=0;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestRecur(root,k);
        return res;
    }
    void kthSmallestRecur(TreeNode root,int k){
        if (root == null) {
            return;
        }
        kthSmallestRecur(root.left,k);
        cur++;
        if (cur==k){
            res=root.val;
            return;
        }
        kthSmallestRecur(root.right,k);
    }
}
