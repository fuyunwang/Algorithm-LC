package com.gopher.leetcode.types.structure.tree;

/**
 * @Title TreeTemplate7
 * @Author fyw
 * @Date 2022-03-07 15:00
 * @Description 搜索二叉树的路径
 */
public class TreeTemplate7 {
    static class Code2096{

    }
    static class Code958{
        // 二叉树的完全性检验
        int n=0,p=0;    // n表示节点数，p表示节点编号最大值
        public boolean isCompleteTree(TreeNode root) {
            if (!dfs(root,1))
                return false;
            return n==p;
        }
        boolean dfs(TreeNode root,int k){ // k表示当前节点的编号
            if (root==null)
                return true;
            if (k>100)              // 一共最多才100个点，编号超出了边界肯定不对
                return false;
            n++;
            p=Math.max(p,k);
            return dfs(root.left,k*2)&&dfs(root.right,2*k+1);
        }
    }
}
