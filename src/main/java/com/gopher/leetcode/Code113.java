package com.gopher.leetcode;

import com.gopher.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
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
        LinkedList<Integer> path=new LinkedList<>();
        if (root!=null) backtrack(root,targetSum,path);
        return res;
    }
    public void backtrack(TreeNode root,int targetSum,LinkedList<Integer> path){
        path.add(root.val);
        targetSum-=root.val;
        if (root.left==null&&root.right==null){
            //已经是叶子结点，判断是否可以作为结果
            if (targetSum==0){
                res.add(new LinkedList<>(path));
            }
        }else{
            if (root.left!=null) backtrack(root.left,targetSum,path);
            if (root.right!=null) backtrack(root.right,targetSum,path);
        }
        path.pollLast();
    }
}
