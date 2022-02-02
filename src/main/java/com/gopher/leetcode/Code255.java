package com.gopher.leetcode;

import java.util.Stack;

/**
 * @Title Code255
 * @Author fyw
 * @Date 2022/2/2 13:34
 * @Description: 验证前序遍历序列二叉搜索树
 * 给定一个 无重复元素 的整数数组 preorder ， 如果它是以二叉搜索树的先序遍历排列 ，返回 true 。
 *
 *输入: preorder = [5,2,1,3,6]
 *输出: true
 *
 * 二叉搜索树的前序遍历有以下特点：
 * 如果出现递减序列，则是左子树，否则是右子树；
 * 右子树一定是递增的
 * 综上，我们可以通俗理解为“总体递增，局部递减”。为了达到“总体递增的效果”，
 * 我们要保证递减序列的第一个元素小于递减结束后即将递增的那个元素。
 * 因此，我们我们使用new_min和栈，如果递减结束后，下一个元素小于递减序列的第一个元素，违背了“总体递增”，立即返回False。

 */
public class Code255 {
    // 单调栈
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack=new Stack<>();
        int min=Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i]<min)
                return false;
            int j=stack.size()-1;
            while (j!=-1&&stack.get(j--)<preorder[i]){
                min=stack.pop();        // 单调栈维护自增
            }
            stack.add(preorder[i]);
        }
        return true;
    }
}
