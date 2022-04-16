package com.gopher.leetcode.types.backtrack;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title RecurReturn
 * @Author fyw
 * @Date 2022/4/17 1:46
 * @Description: 带有返回值的
 */
public class RecurReturn {
    static class Code1022{
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root,0);
        }
        int dfs(TreeNode root,int x){
            if(root==null){
                return 0;
            }
            x=x*2+root.val;
            if(root.left==null&&root.right==null){
                return x;
            }
            int res=0;
            res+=dfs(root.left,x);
            res+=dfs(root.right,x);
            return res;
        }
    }
}
