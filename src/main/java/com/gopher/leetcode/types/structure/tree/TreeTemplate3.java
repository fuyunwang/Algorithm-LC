package com.gopher.leetcode.types.structure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Template3
 * @Author fyw
 * @Date 2022/2/1 20:17
 * @Description: 构造二叉树
 */
public class TreeTemplate3 {
    static class Code105{
        // 前序和中序构造二叉树
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return buildTreePreIn(preorder,0,preorder.length,inorder,0,inorder.length,map);
        }
        public TreeNode buildTreePreIn(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, Map<Integer,Integer> map){
            if (p_start==p_end)
                return null;
            TreeNode root=new TreeNode(preorder[p_start]);
            int inIndex=map.get(preorder[p_start]);
            int leftNum=inIndex-i_start;
            root.left=buildTreePreIn(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,inIndex,map);
            root.right=buildTreePreIn(preorder,p_start+leftNum+1,p_end,inorder,inIndex+1,i_end,map);
            return root;
        }
    }

    static class Code889{
        // 根据前序和后序遍历构造二叉树
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return helper(pre,post,0,pre.length-1,0,post.length-1);
        }
        public TreeNode helper(int[] pre,int[] post,int prestart,int preend,int poststart,int postend){
            if(prestart>preend||poststart>postend)return null;
            TreeNode root=new TreeNode(pre[prestart]);
            if (prestart == preend)
                return root;
            int index=0;
            while(post[index]!=pre[prestart+1]){
                index++;
            }
            root.left=helper(pre,post,prestart+1,prestart+1+index-poststart,poststart,index);
            root.right=helper(pre,post,prestart+2+index-poststart,preend,index+1,preend-1);
            return root;
        }
    }

    static class Code106{
        // 中序和后序构造二叉树
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return buildTreeInPost(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        }
        public TreeNode buildTreeInPost(int[] inorder,int i_start,int i_end,int[] postorder,int p_start,int p_end, Map<Integer,Integer> map) {
            if (p_start > p_end || i_start > i_end)
                return null;
            TreeNode root = new TreeNode(postorder[p_end]);
            int inIndex = map.get(postorder[p_end]);
            int leftNum = inIndex - i_start;
            root.left = buildTreeInPost(inorder, i_start, inIndex - 1, postorder, p_start, p_start + leftNum - 1, map);
            root.right = buildTreeInPost(inorder, inIndex + 1, i_end, postorder, p_start + leftNum, p_end - 1, map);
            return root;
        }
    }

    static class Code1008{
        // 前序遍历构造二叉搜索树
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root=null;
            for (int i = 0; i < preorder.length; i++) {
                root=buildBST(root,preorder[i]);
            }
            return root;
        }
        public TreeNode buildBST(TreeNode root, int num){
            if (root==null)
                return new TreeNode(num);
            if (num> root.val){
                root.right=buildBST(root.right,num);
            }else{
                root.left=buildBST(root.left,num);
            }
            return root;
        }
    }
    static class Code1382{
        // 重构平衡的二叉搜索树
        List<Integer> list=new ArrayList<>();
        int temp[];
        public TreeNode balanceBST(TreeNode root) {
            if (root==null)
                return null;
            dfs(root);
            temp=new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                temp[i]=list.get(i);
            }
            return buildTree(0,list.size()-1);
        }
        void dfs(TreeNode root){
            if (root==null)
                return;
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
        TreeNode buildTree(int start, int end){
            if (start>end)
                return null;
            int mid=start+((end-start)>>1);
            TreeNode root=new TreeNode(temp[mid]);
            root.left=buildTree(start,mid-1);
            root.right=buildTree(mid+1,end);
            return root;
        }
    }
}
