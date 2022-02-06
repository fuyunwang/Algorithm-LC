package com.gopher.leetcode.order.or1000;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code1080
 * @Author fyw
 * @Date 2022/2/6 13:09
 * @Description:
 */
public class Code1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root==null)
            return null;
        if (root.left==null&&root.right==null){
            if (root.val<limit)
                return null;
            else
                return root;
        }
        root.left=sufficientSubset(root.left,limit-root.val);
        root.right=sufficientSubset(root.right,limit-root.val);
        if (root.left==null&&root.right==null)
            return null;
        return root;
    }
}
