package com.gopher.leetcode.types.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title TreeModel1
 * @Author fyw
 * @Date 2022/1/21 15:03
 * @Description: 叶子节点
 */
public class TreeTemplate1 {
    static class Code872{
        // 叶子结点相似的树
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> l1=new ArrayList<>();
            List<Integer> l2=new ArrayList<>();
            leafSimilarRecur(root1,l1);
            leafSimilarRecur(root2,l2);
            return l1.equals(l2);
        }
        public void leafSimilarRecur(TreeNode root, List<Integer> list){
            // 对于叶子节点需要有的终止条件
            if (root==null)
                return;
            if (root.left==null&&root.right==null){
                list.add(root.val);
                return;
            }
            leafSimilarRecur(root.left,list);
            leafSimilarRecur(root.right,list);
        }
    }
    // 根到叶路径上的不足节点
    static class Code1080{
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root==null)
                return null;
            if (root.left==null&& root.right==null){
                return root.val<limit?null:root;
            }
            root.left=sufficientSubset(root.left,limit-root.val);
            root.right=sufficientSubset(root.right,limit-root.val);
            return root.left==root.right?null:root;
        }
    }
}
