package com.gopher.leetcode.order.or200;

import com.gopher.leetcode.types.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title Code257
 * @Author fyw
 * @Date 2022/2/9 13:53
 * @Description: 二叉树的所有路径
 */
public class Code257 {
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null)
            return Collections.emptyList();
        dfs(root,new StringBuilder());
        return res;
    }
    void dfs(TreeNode root, StringBuilder sb){
        sb.append(root.val);
        if (root.left==null&&root.right==null){
            res.add(sb.toString());
            return;
        }
        if (root.left!=null){
            dfs(root.left,new StringBuilder(sb).append("->"));

        }

        if (root.right!=null){
            dfs(root.right,new StringBuilder(sb).append("->"));

        }
    }
}
