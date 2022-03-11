package com.gopher.leetcode.types.dp;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Template7
 * @Author fyw
 * @Date 2022-03-11 9:27
 * @Description 树形DP
 */
public class Template7 {
    static class Code337{
        // 定义 f[u,0]表示当前点不选的情况 f[u,1]表示当前点选的情况
        public int rob(TreeNode root) {
            int[] res=dfs(root);
            return Math.max(res[0],res[1]);
        }
        int[] dfs(TreeNode u){
            if (u==null)
                return new int[]{0,0};
            int[] x=dfs(u.left);
            int[] y=dfs(u.right);
            return new int[]{Math.max(x[0],x[1])+Math.max(y[0],y[1]),x[0]+y[0]+u.val};
        }
    }
}
