package com.gopher.ending.structure.tree;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;
import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Construction
 * @Author fyw
 * @Date 2022/4/17 2:02
 * @Description:
 */
public class Construction {
    // 枚举可能性
    static class Code894{

    }
    static class Code95{

    }
    static class Code96{

    }


    static class Code637{
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1==null&&root2==null){
                return null;
            }
            if (root1==null){
                return root2;
            }
            if (root2==null){
                return root1;
            }
            root1.val+=root2.val;
            root1.left=mergeTrees(root1.left,root2.left);
            root1.right=mergeTrees(root1.right,root2.right);
            return root1;
        }
    }
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
    // 二叉树与链表
    static class Code108_109{
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree1(nums,0,nums.length-1);
        }
        TreeNode buildTree1(int[] nums,int l,int r){
            if (l>r){
                return null;
            }
            int mid=(l+r)>>1;
            TreeNode root=new TreeNode(nums[mid]);
            root.right=buildTree1(nums,mid+1,r);
            root.left=buildTree1(nums,l,mid-1);
            return root;
        }

        public TreeNode sortedListToBST(ListNode head) {
            return buildTree2(head);
        }
        TreeNode buildTree2(ListNode head){
            if (head==null)
                return null;
            if (head.next==null){
                return new TreeNode(head.val);
            }
            ListNode slow=head;
            ListNode fast=head;
            ListNode pre=null;
            while (fast!=null&&fast.next!=null){
                fast=fast.next.next;
                pre=slow;
                slow=slow.next;
            }
            ListNode mid=slow;
            pre.next=null;
            TreeNode root=new TreeNode(mid.val);
            root.left=buildTree2(head);
            root.right=buildTree2(mid.next);
            return root;

        }
    }
    static class Code114{
        TreeNode pre=null;
        public void flatten(TreeNode root) {    // 遍历返回结果是逆序所以拼接之前的节点
            if (root==null)
                return;
            flatten(root.right);
            flatten(root.left);
            root.right=pre;
            root.left=null;
            pre=root;
        }
    }
    static class Code897{
        TreeNode tail;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummyHead=new TreeNode(-1);
            tail=dummyHead;
            dfs(root);
            return dummyHead.right;
        }
        void dfs(TreeNode root){
            if (root==null)
                return;
            dfs(root.left);
            tail.right=root;
            root.left=null;
            tail=tail.right;
            dfs(root.right);
        }
    }



    class Code105{
        // 前序和中序遍历构造二叉树
    }
    class Code106{
        // 中序和后序遍历构造二叉树
    }
    class Code889{
        // 前序和后序遍历构造二叉树
    }

    class Code1028{ // 全局索引，类似Code971翻转二叉树匹配先序遍历
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

    class Code971{

    }



}