package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code124
 * @Author fyw
 * @Date 2022/2/8 21:29
 * @Description: 二叉树中的最大路径和
 */
public class Code124 {
    int result=Integer.MIN_VALUE;
    public int oneSideMax(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left=Math.max(0,oneSideMax(root.left));
        int right=Math.max(0,oneSideMax(root.right));
        result=Math.max(result,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return result;
    }
}
