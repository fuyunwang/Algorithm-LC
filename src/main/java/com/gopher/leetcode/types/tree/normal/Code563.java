package com.gopher.leetcode.types.tree.normal;

import com.gopher.leetcode.types.tree.TreeNode;

/**
 * @Title Code563
 * @Author fyw
 * @Date 2022/2/7 13:33
 * @Description: 二叉树的坡度
 * 左右子树权值和的绝对值
 */
public class Code563 {
    int res=0;
    public int findTilt(TreeNode root) {
        if (root==null)
            return 0;
        dfs(root);
        return res;
    }
    // dfs返回值实现了获得当前节点下的所有权值信息，要想获得所有节点间的坡度信息之和需要额外定义值
    int dfs(TreeNode root){
        if (root==null){
            return 0;
        }
        int l=dfs(root.left);
        int r=dfs(root.right);
        res+=Math.abs(l-r);
        return root.val+l+r;
    }
}
