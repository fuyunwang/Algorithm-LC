package com.gopher.leetcode.types.structure.tree;

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
    // 二叉树的后序遍历，在前序遍历的基础上增加栈实现，左右中 压栈就是中右左
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            final TreeNode pop = stack1.pop();
            stack2.push(pop);
            if (pop.left!=null){
                stack1.push(pop.left);
            }
            if (pop.right!=null){
                stack1.push(pop.right);
            }
        }
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }


    // N叉树的前序遍历
    public List<Integer> preorder(Node root) {
        if (root==null)
            return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            final Node pop = stack.pop();
            res.add(pop.val);
            for (int i = pop.children.size()-1; i >= 0 ; i--) {
                stack.push(pop.children.get(i));
            }
        }
        return res;
    }
    // N叉树的后序遍历
    public List<Integer> postorder(Node root) {
        if (root==null)
            return new ArrayList<>();
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            final Node pop = stack1.pop();
            stack2.push(pop);
            for (int i = 0; i < pop.children.size(); i++) {
                stack1.push(pop.children.get(i));
            }
        }
        List<Integer> res=new ArrayList<>();
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
    // N叉树层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        if (root==null)
            return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final Node poll = queue.poll();
                list.add(poll.val);
                for (Node node:poll.children) {
                    if (node!=null){
                        queue.offer(node);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Code993{
        int[] dfs(TreeNode root,int x,int fa,int depth){
            if (root==null){
                return new int[]{0,0};  // 返回{父节点的值，深度}
            }
            if (root.val==x){
                return new int[]{fa,depth};
            }
            int[] l=dfs(root.left,x,root.val,depth+1);
            int[] r=dfs(root.right,x, root.val,depth+1);
            return new int[]{l[0]+r[0],l[1]+r[1]};  // 由于只能在一侧找到，所以直接求和
        }
        public boolean isCousins(TreeNode root, int x, int y) {
            int[] a=dfs(root,x,-1,0);
            int[] b=dfs(root,y,-1,0);
            return a[0]!=b[0]&&a[1]==b[1];
        }
    }

    static class Code971{
        int k = 0;
        int[] voyage;
        List<Integer> res = new ArrayList();

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            this.voyage = voyage;
            if (dfs(root)) return res;
            return new ArrayList(){{add(-1);}};
        }

        boolean dfs(TreeNode root){
            if (root == null) return true;
            if (root.val != voyage[k]) return false;
            k++;
            if (root.left != null && root.left.val != voyage[k]){
                res.add(root.val);
                return dfs(root.right) && dfs(root.left);
            } else {
                return dfs(root.left) && dfs(root.right);
            }
        }
    }
}





