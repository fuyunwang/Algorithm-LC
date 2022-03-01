package com.gopher.leetcode.types.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title TreeModel1
 * @Author fyw
 * @Date 2022/1/21 15:03
 * @Description: 相同的树，对称二叉树，叶子结点相似的二叉树
 */
public class TreeTemplate1 {
    // 递归解决对称二叉树
    public boolean isSymmetricRecur(TreeNode root) {
        return recur(root.left,root.right);
    }
    private boolean recur(TreeNode left,TreeNode right){
        if (left==null&&right==null)
            return true;
        if (left==null||right==null||left.val!=right.val)
            return false;
        return recur(left.right,right.left)&&recur(left.left,right.right);
    }

    // 相同的树与对称二叉树相反
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 先检查当前节点
        if (p==null&&q==null)
            return true;
        if (p==null||q==null||p.val!=q.val)
            return false;
        // 递归检查左右子树
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    // 叶子结点相似的树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        leafSimilarRecur(root1,l1);
        leafSimilarRecur(root2,l2);
        return l1.equals(l2);
    }
    public void leafSimilarRecur(TreeNode root, List<Integer> list){
        // 对于叶子节点需要有的终止条件
        if (root==null)
            return;
        if (root.left==null&&root.right==null){
            list.add(root.val);
            return;
        }
        leafSimilarRecur(root.left,list);
        leafSimilarRecur(root.right,list);
    }
}
