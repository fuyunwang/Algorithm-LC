package com.gopher.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Template3
 * @Author fyw
 * @Date 2022/2/1 20:17
 * @Description: 前序中序构造二叉树，中序后序构造二叉树
 */
public class TreeTemplate3 {
    // 前序和中序构造二叉树
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
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

    // 中序和后序构造二叉树
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTreeInPost(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    public TreeNode buildTreeInPost(int[] inorder,int i_start,int i_end,int[] postorder,int p_start,int p_end, Map<Integer,Integer> map){
        if (p_start>p_end||i_start>i_end)
            return null;
        TreeNode root=new TreeNode(postorder[p_end]);
        int inIndex=map.get(postorder[p_end]);
        int leftNum=inIndex-i_start;
        root.left=buildTreeInPost(inorder,i_start,inIndex-1,postorder,p_start,p_start+leftNum-1,map);
        root.right=buildTreeInPost(inorder,inIndex+1,i_end,postorder,p_start+leftNum,p_end-1,map);
        return root;
    }

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
