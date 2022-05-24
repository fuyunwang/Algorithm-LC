package com.fuyunwang.bilibili.order.hot100;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code124
 * @Author fyw
 * @Date 2022/5/24 16:08
 * @Description:
 */
public class Code124 {
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    int dfs(TreeNode root){ // 返回以当前根节点root开始下的最大路径（左子树或者右子树）
        if (root==null)
            return 0;
        int l=Math.max(0,dfs(root.left));
        int r=Math.max(0,dfs(root.right));
        res=Math.max(res,l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}
