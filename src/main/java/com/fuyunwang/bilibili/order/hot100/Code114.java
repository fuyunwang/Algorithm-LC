package com.fuyunwang.bilibili.order.hot100;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code114
 * @Author fyw
 * @Date 2022/5/24 15:46
 * @Description:
 */
public class Code114 {
    public void flatten(TreeNode root) {
        while (root!=null){
            TreeNode cur=root.left;
            if (cur!=null){
                while (cur.right!=null){
                    cur=cur.right;
                }
                cur.right=root.right;
                root.right=root.left;
                root.left=null;
            }
            root=root.right;
        }
    }
}
