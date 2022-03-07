package com.gopher.leetcode.types.structure.tree;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

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
        if (left!=null&&right!=null){
            // 说明在左右子树中，左右子树都存在
            return root;
        }
        return left==null?right:left;
    }

    static class Code1644{
        // 可能某一节点不存在的情况
        private TreeNode ans;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            findLowestCommon(root, p, q);
            return ans;
        }
        private boolean findLowestCommon(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return false;

            int left = findLowestCommon(root.left, p, q) ? 1 : 0;
            int right = findLowestCommon(root.right, p, q) ? 1 : 0;
            int cur = root == p || root == q ? 1 : 0;
            if(left + right + cur == 2) {
                if(ans == null) {
                    ans = root;
                }
            }
            return left + cur + right == 1;
        }
    }

    static class Code1650{
        class Node {
            public int val;
            public Node left;
            public Node right;
            public Node parent;
        };
        public Node lowestCommonAncestor1(Node p, Node q) {
            // 解法1
            Set<Integer> set = new HashSet();
            while(p != null) {
                set.add(p.val);
                p = p.parent;
            }
            while(q != null) {
                if(set.contains(q.val)) {
                    return q;
                }
                q = q.parent;
            }
            return null;
        }
        public Node lowestCommonAncestor(Node p, Node q) {
            // 链表相交
            Node x=p;
            Node y=q;
            while (x!=y){
                x=x==null?q:x.parent;
                y=y==null?p:y.parent;
            }
            return x;
        }
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


    static class Code2096{
        // LCA+回溯
        // 找到两个值对应的树节点的最近公共祖先
        public TreeNode lca(TreeNode root,int startValue,int endValue){
            if (root==null)
                return null;
            if (startValue==root.val||endValue==root.val){
                return root;
            }
            TreeNode left=lca(root.left, startValue, endValue);
            TreeNode right=lca(root.right,startValue,endValue);
            if (left!=null&&right!=null)
                return root;
            return left==null?right:left;
        }
        StringBuilder res=new StringBuilder();
        public String getDirections(TreeNode root, int startValue, int destValue) {
            if (root==null)
                return "";
            TreeNode parent=lca(root,startValue,destValue);
            int num=getStart(parent,startValue);
            for (int i = 0; i < num; i++) {
                res.append("U");
            }
            getEnd(parent,destValue,new StringBuilder());
            return res.toString();
        }
        int getStart(TreeNode parent,int startValue){
            if (parent==null)
                return 10000;// 如果没有最近公共节点说明不可能到达
            if (parent.val==startValue)
                return 0;
            return Math.min(getStart(parent.left,startValue),getStart(parent.right,startValue))+1;//左右子树找到最大的
        }
        void getEnd(TreeNode parent, int endValue, StringBuilder sb){
            if (parent==null){
                return;
            }
            if (parent.val==endValue){
                res.append(sb);
                return;
            }
            if (parent.left!=null){
                sb.append("L");
                getEnd(parent.left,endValue,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            if (parent.right!=null){
                sb.append("R");
                getEnd(parent.right,endValue,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

}
