package com.gopher.ending.structure.tree;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title StateArray
 * @Author fyw
 * @Date 2022/4/17 1:54
 * @Description: 状态数组类别要采用后序遍历
 */
public class StateArray {

    static class Code979{
        // 二叉树中分配硬币，递归函数的定义：每棵子树对应节点数、金币数、操作数
        // 后序遍历，因为节点数、金币数、操作数必须由子树来确定
        public int distributeCoins(TreeNode root) {
            return dfs(root)[2];
        }
        int[] dfs(TreeNode root){
            if (root==null){
                return new int[]{0,0,0};
            }
            int[] left=dfs(root.left);
            int[] right=dfs(root.right);
            int x=left[0]+right[0]+1;
            int y=left[1]+right[1]+root.val;
            return new int[]{x,y,Math.abs(x-y)+left[2]+right[2]};
        }
    }

    static class Code993{
        public boolean isCousins(TreeNode root, int x, int y) {
            int[] xRes=dfs(root,x,-1,0);
            int[] yRes=dfs(root,y,-1,0);
            return xRes[0]!=yRes[0]&&xRes[1]==yRes[1];
        }
        // 返回值分别为父节点和深度
        int[] dfs(TreeNode root,int cur,int father,int depth){
            if(root==null){
                return new int[]{0,0};
            }
            if (root.val==cur){
                return new int[]{father,depth};
            }
            int[] left=dfs(root.left,cur,root.val,depth+1);
            int[] right=dfs(root.right,cur,root.val,depth+1);
            return new int[]{left[0]+right[0],left[1]+right[1]};
        }
    }

}
