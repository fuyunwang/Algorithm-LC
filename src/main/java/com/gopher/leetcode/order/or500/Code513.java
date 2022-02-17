package com.gopher.leetcode.order.or500;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code513
 * @Author fyw
 * @Date 2022/2/17 19:40
 * @Description: 找树左下角的值
 * 深度最大最左侧的点，类似二叉树的右视图
 */
public class Code513 {
    int res;
    int maxDepth=0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,1);
        return res;
    }
    void dfs(TreeNode root, int depth){
        if (root==null)
            return;
        if (depth>maxDepth){
            maxDepth=depth;
            res=root.val;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
