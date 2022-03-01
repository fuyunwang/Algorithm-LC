package com.gopher.leetcode.order.or1100;

import com.gopher.leetcode.types.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Title Code1110
 * @Author fyw
 * @Date 2022/2/4 12:24
 * @Description: 删点成林，后续遍历的一类题型。核心在于通过传入父节点来报错删除当前节点之后的兄弟节点
 */
public class Code1110 {
    List<TreeNode> res=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set=new HashSet<>();
        for (int i:to_delete){
            set.add(i);
        }

        dfs(null,root,set);
        if (!set.contains(root.val))
            res.add(root);
        return res;
    }
    public void dfs(TreeNode parent, TreeNode root, Set<Integer> set){
        if (root==null)
            return;
        dfs(root,root.left,set);
        dfs(root,root.right,set);
        // 集合包括要删除的值
        if (set.contains(root.val)){
            // 首先改变根节点的树
            if(parent!=null&&parent.left==root) parent.left=null;
            if(parent!=null&&parent.right==root) parent.right=null;
            // 断开之后的子节点树进行纳入结果集
            if (root.left!=null)
                res.add(root.left);
            if (root.right!=null)
                res.add(root.right);
        }
    }
}
