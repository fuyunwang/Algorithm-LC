package com.gopher.leetcode.types.structure.tree;

/**
 * @Title TreeModel2
 * @Author fyw
 * @Date 2022/1/21 15:04
 * @Description: 二叉树路径求和
 */
public class TreeTemplate2 {
    static class Code1080{

    }
    static class Code538{
        // 累加数之和其实就是逆着遍历然后累加
        int sum=0;
        public TreeNode bstToGst(TreeNode root) {
            if (root==null)
                return null;
            bstToGst(root.right);
            root.val+=sum;
            sum=root.val;
            bstToGst(root.left);
            return root;
        }
    }
    static class Code1022{
        public int sumRootToLeaf(TreeNode root) {
            return cal(root,0);
        }
        int cal(TreeNode root, int x){
            if (root==null){
                return 0;
            }
            x=x*2+root.val;
            if (root.left==null&&root.right==null){
                return x;
            }
            int res=0;      // 累加求和
            if (root.left!=null)
                res+=cal(root.left,x);
            if (root.right!=null)
                res+=cal(root.right,x);
            return res;
        }
    }
}
