package com.gopher.leetcode.types.backtrack;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title BacktrackTemplate6
 * @Author fyw
 * @Date 2022-03-05 22:37
 * @Description 树形DP 二叉树路径求和
 */
public class BacktrackTemplate6 {
    static class Code1022{
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root,0);
        }
        int dfs(TreeNode node,int x){
            if (node==null)
                return 0;
            x=x*2+node.val;

            if (node.left==null&&node.right==null){
                return x;// 只有到当前叶子节点才将这一路径的数据返回
            }
            // 如果不是叶子节点，中间节点需要累计
            int res=0;
            if (node.left!=null){
                res+=dfs(node.left,x);
            }
            if (node.right!=null)
                res+=dfs(node.right,x);
            return res;
        }
    }
}
