package com.gopher.leetcode.order.or100;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code98
 * @Author fyw
 * @Date 2022/1/29 22:21
 * @Description: 验证二叉搜索树
 */
public class Code98 {
    TreeNode pre=null;
    boolean res=true;
    public boolean isValidBST(TreeNode root) {
        isValidBSTRecur(root);
        return res;
    }
    public void isValidBSTRecur(TreeNode root){
        if (root==null)
            return;
        isValidBSTRecur(root.left);
        if (pre==null){
            pre=root;
        }else{
            if (pre.val>=root.val){
                res=false;
                return;
            }
            pre=root;
        }
        isValidBSTRecur(root.right);
    }

}
