package com.gopher.leetcode.types.structure.tree;

/**
 * @Title TreeTemplate8
 * @Author fyw
 * @Date 2022-03-07 15:30
 * @Description 修改二叉树
 */
public class TreeTemplate8 {
    static class Code814{

    }
    static class Code1932{

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
