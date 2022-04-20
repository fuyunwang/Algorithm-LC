package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code113
 * @Author fyw
 * @Date 2022/1/26 21:40
 * @Description: 路径总和 类似全排列
 */
public class Code113 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new LinkedList<>());
        return res;
    }

    void dfs(TreeNode root,int targetSum,LinkedList<Integer> path){
        if (root==null)
            return;
        path.add(root.val);
        targetSum-=root.val;
        if (root.left==null&&root.right==null&&targetSum==0){
            res.add(new LinkedList<>(path));
            return;
        }
        if (root.left!=null){
            dfs(root.left,targetSum,path);
            path.removeLast();
        }
        if (root.right!=null){
            dfs(root.right,targetSum,path);
            path.removeLast();
        }
    }
}
