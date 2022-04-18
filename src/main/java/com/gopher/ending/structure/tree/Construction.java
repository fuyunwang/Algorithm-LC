package com.gopher.ending.structure.tree;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Construction
 * @Author fyw
 * @Date 2022/4/17 2:02
 * @Description:
 */
public class Construction {
    static class Code998{
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root==null){
                return new TreeNode(val);
            }
            if (root.val<val){
                TreeNode node=new TreeNode(val);
                node.left=root;
                return node;
            }else{
                root.right=insertIntoMaxTree(root.right,val);
            }
            return root;
        }
    }
    static class Code1008{
        // 前序遍历构造二叉搜索树
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root=null;
            for (int i = 0; i < preorder.length; i++) {
                root=buildTree(root,preorder[i]);
            }
            return root;
        }
        TreeNode buildTree(TreeNode root,int x){    // 插入元素到BST
            if (root==null){
                return new TreeNode(x);
            }
            if (root.val<x){
                root.right=buildTree(root.right,x);
            }
            if (root.val>x){
                root.left=buildTree(root.left,x);
            }
            return root;
        }
    }


    class Code889{
        // 根据前序遍历和后序遍历构造二叉树
    }

    class Code1028{
        int idx=0;
        public TreeNode recoverFromPreorder(String traversal) {
            return buildTree(traversal,0);
        }
        TreeNode buildTree(String str,int depth){
            if (idx>=str.length()){
                return null;
            }
            int d=0;
            int temp=idx;
            while (str.charAt(temp)=='-'){
                temp++;
                d++;
            }
            if (d!=depth){
                return null;
            }
            idx=temp;
            int start=idx;
            while (idx<str.length()&&Character.isDigit(str.charAt(idx))){
                idx++;
            }
            int val=Integer.parseInt(str.substring(start,idx));
            TreeNode root=new TreeNode(val);
            root.left=buildTree(str,depth+1);
            root.right=buildTree(str,depth+1);
            return root;
        }
    }














    class Code897{
        TreeNode tail;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummy=new TreeNode(-1);
            tail=dummy;
            dfs(root);
            return dummy.right;
        }
        void dfs(TreeNode root){
            if(root==null){
                return;
            }
            dfs(root.left);
            tail.right=root;
            root.left=null;
            tail=root;
            dfs(root.right);
        }
    }


}