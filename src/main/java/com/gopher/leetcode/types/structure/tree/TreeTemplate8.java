package com.gopher.leetcode.types.structure.tree;

import java.util.*;
/**
 * @Title TreeTemplate8
 * @Author fyw
 * @Date 2022-03-07 15:30
 * @Description 修改二叉树
 */
public class TreeTemplate8 {
    static class Code669{
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return null;
            if (root.val < low) return trimBST(root.right, low, high);
            if (root.val > high) return trimBST(root.left, low, high);
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
    static class Code814{
        // 判断二叉树的子树中是否含1，如果含1那么删除否则不删除
        public TreeNode pruneTree(TreeNode root) {
            if (!dfs(root))
                root=null;
            return root;
        }
        boolean dfs(TreeNode root){
            if (root==null)
                return false;
            if (!dfs(root.left))
                root.left=null;
            if (!dfs(root.right))
                root.right=null;
            return root.val==1||root.right!=null||root.left!=null;
        }
    }
    static class Code1932{

    }
    static class Code623{
        // 好题
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode cur = new TreeNode(v);
                cur.left = root;
                return cur;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            for (int i = 0; i < d - 2; i++) {
                for (int j = q.size(); j > 0; j--) {
                    TreeNode t = q.poll();
                    if (t.left != null) q.offer(t.left);
                    if (t.right != null) q.offer(t.right);
                }
            }

            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                TreeNode l = new TreeNode(v), r = new TreeNode(v);
                l.left = t.left; r.right = t.right;
                t.left = l; t.right = r;
            }

            return root;
        }

    }
    static class Code998{
        // 建大根堆
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root==null){
                return new TreeNode(val);
            }
            if (val>root.val){
                TreeNode node=new TreeNode(val);
                node.left=root;
                return node;
            }
            root.right=insertIntoMaxTree(root.right,val);
            return root;
        }
    }
    static class Code617{
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1==null){
                return root2;
            }
            if(root2==null){
                return root1;
            }
            root1.val+=root2.val;
            root1.left=mergeTrees(root1.left,root2.left);
            root1.right=mergeTrees(root1.right,root2.right);
            return root1;
        }
    }

}
