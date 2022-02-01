package com.gopher.leetcode;

import com.gopher.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code95
 * @Author fyw
 * @Date 2022/2/1 16:46
 * @Description:
 */
public class Code95 {
    public List<TreeNode> generateTrees(int n) {
        if (n==0)
            return new ArrayList<>();
        return dfs(1,n);
    }
    List<TreeNode> dfs(int l,int r){
        List<TreeNode> list=new ArrayList<>();
        if (l>r){
            list.add(null);
            return list;
        }
        for (int i = l; i <= r; i++) {

            List<TreeNode> lefts=dfs(l,i-1);
            List<TreeNode> rights=dfs(i+1,r);
            for (TreeNode left:lefts){
                for (TreeNode right:rights){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
