package com.gopher.ending.mapstore;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-14 10:53
 * @Description
 */
public class Template1 {
    static class Code653{
        Set<Integer> set=new HashSet<>();
        public boolean findTarget(TreeNode root, int k) {
            return dfs(root,k);
        }
        boolean dfs(TreeNode root,int k){
            if (root==null){
               return false;
            }
            if (dfs(root.left, k)) return true;
            int cur=root.val;
            if (set.contains(k-cur)){
                return true;
            }
            set.add(cur);
            return  dfs(root.right,k);
        }
    }
}
