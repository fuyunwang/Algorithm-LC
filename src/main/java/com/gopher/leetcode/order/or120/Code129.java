package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code129
 * @Author fyw
 * @Date 2022/2/9 14:02
 * @Description: 求根节点到叶子结点的数字之和
 */
public class Code129 {
    int res=0;
    public int sumNumbers(TreeNode root) {
        if (root!=null)
            dfs(root,0);
        return res;
    }
    void dfs(TreeNode root,int number){ // dfs遍历得到每一棵子树的结果
        if (root==null){
            return;
        }
        number=number*10+root.val;
        if (root.left==null&&root.right==null){
            res+=number;
            return;
        }
        dfs(root.left,number);
        dfs(root.right,number);
    }
}
