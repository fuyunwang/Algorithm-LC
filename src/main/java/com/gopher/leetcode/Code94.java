package com.gopher.leetcode;

import com.gopher.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Title Code94
 * @Author fyw
 * @Date 2022/2/1 19:50
 * @Description: 迭代二叉树中序遍历使用栈辅助实现，首先将所有的左子树节点加入然后依次弹出并加入右子树
 */
public class Code94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                final TreeNode pop = stack.pop();
                res.add(pop.val);
                cur=pop.right;
            }
        }
        return res;
    }
}
