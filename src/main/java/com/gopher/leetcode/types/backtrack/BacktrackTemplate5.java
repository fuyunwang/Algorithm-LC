package com.gopher.leetcode.types.backtrack;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.*;

/**
 * @Title BacktrackTemplate5
 * @Author fyw
 * @Date 2022/2/9 12:30
 * @Description: 电话号码的字母组合、不同的搜索二叉树、Code491递增子序列、Code93复原IP地址、Code1863
 */
public class BacktrackTemplate5 {
    class Code95{
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
}
