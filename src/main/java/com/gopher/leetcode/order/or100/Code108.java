package com.gopher.leetcode.order.or100;

import com.gopher.leetcode.types.structure.tree.TreeNode;

/**
 * @Title Code108
 * @Author fyw
 * @Date 2022/2/1 13:22
 * @Description: 有序数组转BST
 * Code98、Code108、Code1382一类题
 */
public class Code108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums,int l,int r){
        if (l>r)
            return null;
        int mid=l+r>>1;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(nums,l,mid-1);
        root.right=buildTree(nums,mid+1,r);
        return root;
    }
}
