package com.gopher.leetcode.tree;

import java.util.*;

/**
 * @Title TreeTemplate4
 * @Author fyw
 * @Date 2022/2/1 20:19
 * @Description: 二叉树的遍历
 */
public class TreeTemplate4 {
    public int[] levelOrder(TreeNode root){
        if (root==null)
            return new int[0];
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        HashSet<TreeNode> visited=new HashSet<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                visited.add(poll);
                list.add(poll.val);
                TreeNode left=poll.left;
                TreeNode right=poll.right;
                if (left!=null&&!visited.contains(left)){
                    queue.add(left);
                }
                if (right!=null&&!visited.contains(right)){
                    queue.add(right);
                }
            }
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    // 自底向上返回
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        HashSet<TreeNode> visited=new HashSet<>();
        Stack<List<Integer>> stack=new Stack<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                visited.add(poll);
                temp.add(poll.val);
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if (left!=null&&!visited.contains(left)){
                    queue.offer(left);
                }
                if (right!=null&&!visited.contains(right)){
                    queue.offer(right);
                }
            }
            stack.push(temp);
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    // 锯齿形层次遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();
        queue.offer(root);
        boolean flag=true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp=new ArrayList<>();
            Stack<Integer> stack=new Stack();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                visited.add(poll);
                if (flag){
                    temp.add(poll.val);
                }else{
                    stack.push(poll.val);
                }
                TreeNode left = poll.left;
                if (left!=null&&!visited.contains(left)){
                    queue.offer(left);
                }
                TreeNode right=poll.right;
                if (right!=null&&!visited.contains(right)){
                    queue.offer(right);
                }
            }
            flag=!flag;
            while (!stack.isEmpty()){
                temp.add(stack.pop());
            }
            res.add(temp);
        }
        return res;
    }

    // 中序遍历使用栈辅助迭代，核心在于首先将所有最左子树节点依次加入
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur=pop.right;
            }
        }
        return res;
    }
    // 前序遍历使用栈辅助迭代，核心在于层序遍历类似
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            final TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if (pop.left!=null){
                stack.push(pop.left);
            }
        }
        return res;
    }

}
