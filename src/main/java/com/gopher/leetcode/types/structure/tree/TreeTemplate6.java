package com.gopher.leetcode.types.structure.tree;

/**
 * @Title TreeTemplate6
 * @Author fyw
 * @Date 2022/2/7 18:27
 * @Description: 最近公共祖先
 */
public class TreeTemplate6 {
    // 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val>q.val) {
            TreeNode temp=p;
            p=q;
            q=temp;
        }
        if (p.val<=root.val&&q.val>=root.val)
            return root;
        if (q.val<root.val)
            return lowestCommonAncestorBST(root.left,p,q);
        return lowestCommonAncestorBST(root.right,p,q);
    }

    // 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if (root==p||q==root)
            return root;
        final TreeNode left = lowestCommonAncestor(root.left, p, q);
        final TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left==null&&right==null){
            return null;// 说明都没找到
        }
        if (left!=null&&right!=null){
            // 说明在左右子树中，左右子树都存在
            return root;
        }
        return left==null?right:left;
    }

    static class Code865{
        // 最深叶子节点的最近公共祖先
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            if (root==null)
                return null;
            int left=getDepth(root.left);
            int right=getDepth(root.right);
            if (left==right)
                return root;
            if (left>right){
                return lcaDeepestLeaves(root.left);
            }
            return lcaDeepestLeaves(root.right);
        }
        int getDepth(TreeNode root){
            if (root==null)
                return 0;
            return Math.max(getDepth(root.left),getDepth(root.right))+1;
        }
    }
}
