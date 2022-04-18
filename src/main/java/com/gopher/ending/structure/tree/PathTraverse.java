package com.gopher.ending.structure.tree;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title PathTraverse
 * @Author fyw
 * @Date 2022/4/17 1:47
 * @Description:
 */
public class PathTraverse {

    class Code113{
        // 路径总和
        List<List<Integer>> res=new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            backtrack(root,targetSum,new LinkedList<>());
            return res;
        }
        void backtrack(TreeNode root,int target,LinkedList<Integer> path){
            if (root==null){
                return;
            }
            path.addLast(root.val);
            target-=root.val;
            if (root.left==null&&root.right==null){
                if (target==0){
                    res.add(new LinkedList<>(path));
                    return;
                }else{
                    return;
                }
            }
            if (root.left!=null){
                backtrack(root.left,target,path);
                path.removeLast();
            }
            if (root.right!=null){
                backtrack(root.right,target,path);
                path.removeLast();
            }
        }
    }

    static class Code257{
        List<String> res=new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root,new StringBuilder());
            return res;
        }
        void dfs(TreeNode root,StringBuilder sb){
            if(root==null){
                return;
            }
            sb.append(root.val);
            if(root.left==null&&root.right==null){
                res.add(sb.toString());
                return;
            }else{
                dfs(root.left,new StringBuilder(sb).append("->"));
                dfs(root.right,new StringBuilder(sb).append("->"));
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }

    class Code797{
        List<List<Integer>> res=new LinkedList<>();
        int[][] g;
        int n;
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.g=graph;
            n=g.length;
            backtrack(0,new LinkedList<>());
            return res;
        }
        void backtrack(int index,LinkedList<Integer> path){
            path.addLast(index);
            if (index==n-1){
                res.add(new LinkedList<>(path));
                return;
            }
            for(int x:g[index]){
                backtrack(x,path);
                path.removeLast();
            }
        }

    }

    static class Code988{
        String ans;
        // 字符串拼接
        public String smallestFromLeaf(TreeNode root) {
            dfs(root,new StringBuilder());
            return ans;
        }
        void dfs(TreeNode root,StringBuilder sb){
            if (root==null)
                return;
            sb.append((char)(root.val+'a'));
            if (root.left==null&&root.right==null){
                sb.reverse();
                if (ans==null||sb.toString().compareTo(ans)<0) ans=sb.toString();
                sb.reverse();
            }else{
                dfs(root.left,new StringBuilder(sb));
                dfs(root.right,new StringBuilder(sb));
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static class Code669{   // 类似Code938
        public TreeNode trimBST(TreeNode root, int low, int high) {
            return dfs(root,low,high);
        }
        TreeNode dfs(TreeNode root,int low,int high){
            if (root==null){
                return null;
            }
            if (root.val<low){
                TreeNode right=root.right;
                return trimBST(right,low,high);
            }
            if (root.val>high){
                TreeNode left=root.left;
                return trimBST(left,low,high);
            }
            root.left=trimBST(root.left,low,high);
            root.right=trimBST(root.right,low,high);
            return root;
        }
    }

    static class Code99{
        TreeNode pre;
        TreeNode res1,res2;
        public void recoverTree(TreeNode root) {
            dfs(root);
            int temp=res1.val;
            res1.val=res2.val;
            res2.val=temp;
        }
        void dfs(TreeNode root){
            if (root==null)
                return;
            dfs(root.left);
            if (pre==null){
                pre=root;
            }else{
                if (pre.val>root.val){
                    if(res1==null){     // 只更新一次
                        res1=pre;
                    }
                    res2=root;  // 找到可以交换的最后一位置
                }
                pre=root;
            }
            dfs(root.right);
        }
    }

    // 遍历过程中的修改
    static class Code814{   // 类似669
        // 每个节点都要有含1的子树，如果没有就把当前节点删除
        public TreeNode pruneTree(TreeNode root) {
            if (!dfs(root)){
                root=null;
            }
            return root;
        }
        boolean dfs(TreeNode root){ // 判断以root为根的节点是否含有1的子树，并在过程中进行二叉树剪枝
            if (root==null){
                return false;
            }
            if (!dfs(root.left)){
                root.left=null;
            }
            if (!dfs(root.right)){
                root.right=null;
            }
            return root.val==1||root.left!=null||root.right!=null;
        }
    }
    static class Code1080{  // 类似题目814
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            return dfs(root,0,limit);
        }
        TreeNode dfs(TreeNode root,int sum,int limit){
            if (root==null){
                return null;
            }
            sum+=root.val;
            if (root.left==null&&root.right==null){
                if (sum<limit){
                    root=null;
                }
            }else{
                if (root.left!=null){
                    root.left=dfs(root.left,sum,limit);
                }
                if (root.right!=null){
                    root.right=dfs(root.right,sum,limit);
                }
                if (root.left==null&&root.right==null){
                    root=null;
                }
            }
            return root;
        }
    }
    static class Code450{

    }


    static class Code865{
        // 具有所有最深节点的最小子树，有点后续遍历的意思，涉及到深度
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return getSubTree(root);
        }
        int getDepth(TreeNode root){
            if (root==null)
                return 0;
            return Math.max(getDepth(root.left),getDepth(root.right))+1;
        }
        TreeNode getSubTree(TreeNode root){
            if (root==null)
                return null;
            int left=getDepth(root.left);
            int right=getDepth(root.right);
            if (left==right){
                return root;
            }
            if (left>right){
                return getSubTree(root.left);
            }
            return getSubTree(root.right);
        }
    }
    static class Code867{   // 类似二叉树的直径，后序遍历，涉及到路径长度
        int res=0;
        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return res;
        }
        int dfs(TreeNode root){
            if (root==null)
                return 0;
            int l=dfs(root.left),r=dfs(root.right);
            if (root.left==null||root.left.val!=root.val){
                l=0;
            }
            if (root.right==null||root.right.val!=root.val){
                r=0;
            }
            res=Math.max(res,r+l);
            return Math.max(l,r)+1;
        }
    }
    static class Code543{   // 二叉树的直径，类似867题目，涉及到路径长度
        int res=0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }
        int dfs(TreeNode root){ // 返回以当前节点的向下走最长的路径
            if (root==null){
                return 0;
            }
            int left=dfs(root.left);
            int right=dfs(root.right);
            res=Math.max(res,left+right);
            return Math.max(left,right)+1;
        }
    }
    static class Code235_236{
        // 最近公共祖先 LCA
    }
}
