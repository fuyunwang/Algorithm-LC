package com.gopher.leetcode.order.or500;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code572
 * @Author fyw
 * @Date 2022/2/9 14:48
 * @Description: 另一棵树的子树
 * 经典树哈希：如果两棵数的形态相同则哈希值一样否则不一样
 * root+l*P+r*Q
 */
public class Code572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root==null&subRoot==null)
            return true;
        if (root==null||subRoot==null)
            return false;
        return isSameTree(root,subRoot)||isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    public boolean isSameTree(TreeNode root1,TreeNode root2){
        if (root1==null&&root2==null)
            return true;
        if (root1==null||root2==null)
            return false;
        if (root1.val!= root2.val)
            return false;
        return isSameTree(root1.left,root2.left)&&isSameTree(root1.right,root2.right);
    }
}
