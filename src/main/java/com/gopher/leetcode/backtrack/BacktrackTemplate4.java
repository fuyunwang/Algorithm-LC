package com.gopher.leetcode.backtrack;

import com.gopher.leetcode.tree.TreeNode;

import java.util.*;

/**
 * @Title BacktrackTemplate4
 * @Author fyw
 * @Date 2022/2/7 19:18
 * @Description: Code113路径总和、活字印刷、Code257输出叶子结点路径
 */
public class BacktrackTemplate4 {
    class Code113{
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
    class Code1079{
        // 活字印刷
        public int numTile2(String tiles){
            boolean[] visited=new boolean[tiles.length()];
            return dfs2(tiles,new HashSet<>(),visited,new StringBuilder())-1;//空减去
        }
        public int dfs2(String tiles, HashSet<String> set,boolean[] visited,StringBuilder sb){
            set.add(sb.toString());

            for (int i = 0; i < tiles.length(); i++) {
                if (!visited[i]){
                    visited[i]=true;
                    sb.append(tiles.charAt(i));
                    dfs2(tiles,set,visited,sb);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i]=false;
                }
            }
            return set.size();
        }
    }
    class Code257{
        List<String> res=new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            if (root==null)
                return Collections.emptyList();
            dfs(root,new StringBuilder());
            return res;
        }
        void dfs(TreeNode root,StringBuilder sb){
            sb.append(root.val);    // 注意路径选择和位置加入
            if (root.left==null&&root.right==null){
                res.add(sb.toString());
                return;
            }

            if (root.left!=null){
                // 注意此处的技巧，使用new StringBuilder创建了新的对象，原始上下文中的sb对象是保存在操作数栈中的，避免回溯过程中删除操作
                // 手动删除是删不干净的，因为树的路径与全排列还是不一样的
                dfs(root.left,new StringBuilder(sb).append("->"));
            }

            if (root.right!=null){
                dfs(root.right,new StringBuilder(sb).append("->"));
            }

        }
    }

}
