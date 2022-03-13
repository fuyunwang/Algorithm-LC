package com.gopher.leetcode.types.structure.tree;

import java.util.*;

/**
 * @Title TreeModel2
 * @Author fyw
 * @Date 2022/1/21 15:04
 * @Description: 二叉树路径求和
 */
public class TreeTemplate2 {
    static class Code1080{

    }
    static class Code538{
        // 累加数之和其实就是逆着遍历然后累加
        int sum=0;
        public TreeNode bstToGst(TreeNode root) {
            if (root==null)
                return null;
            bstToGst(root.right);
            root.val+=sum;
            sum=root.val;
            bstToGst(root.left);
            return root;
        }
    }
    static class Code1022{
        public int sumRootToLeaf(TreeNode root) {
            return cal(root,0);
        }
        int cal(TreeNode root, int x){
            if (root==null){
                return 0;
            }
            x=x*2+root.val;
            if (root.left==null&&root.right==null){
                return x;
            }
            int res=0;      // 累加求和
            if (root.left!=null)
                res+=cal(root.left,x);
            if (root.right!=null)
                res+=cal(root.right,x);
            return res;
        }
    }

    static class Code979{
        int[] dfs(TreeNode root){
            if (root==null)
                return new int[]{0,0,0};// 节点数、金币数、当前子树的操作数
            int[] l=dfs(root.left);
            int[] r=dfs(root.right);
            int x = l[0] + r[0] + 1, y = l[1] + r[1] + root.val;
            return new int[]{x, y, Math.abs(x - y) + l[2] + r[2]};
        }
        public int distributeCoins(TreeNode root) {
            return dfs(root)[2];
        }
    }

    static class Code863{
        // 二叉树中所有距离为K的点，先建图再搜索，注意无向图父节点不能多次搜索要标识
        Map<TreeNode,List<TreeNode>> g=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            dfs1(root);
            dfs2(target,null,k);
            return ans;
        }
        // 建图
        void dfs1(TreeNode root){
            if(root==null){
                return;
            }
            if(root.left!=null){
                g.computeIfAbsent(root,l->new ArrayList<>()).add(root.left);
                g.computeIfAbsent(root.left,l->new ArrayList<>()).add(root);
                dfs1(root.left);
            }
            if (root.right!=null){
                g.computeIfAbsent(root,l->new ArrayList<>()).add(root.right);
                g.computeIfAbsent(root.right,l->new ArrayList<>()).add(root);
                dfs1(root.right);
            }
        }
        void dfs2(TreeNode root, TreeNode father, int k){   // father保证不会回头搜索
            if (k==0){
                ans.add(root.val);
                return;
            }
            for (TreeNode node:g.getOrDefault(root,new ArrayList<>())){
                if (node!=father){
                    dfs2(node,root,k-1);
                }
            }
        }
    }
}
