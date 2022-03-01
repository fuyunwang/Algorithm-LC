package com.gopher.leetcode.order.or700;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code701
 * @Author fyw
 * @Date 2022/2/2 21:19
 * @Description:
 */
public class Code701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }else{
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
