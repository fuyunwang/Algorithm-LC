package com.fuyunwang.bilibili.tree;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.*;

/**
 * @Title PathTraverseTemplate
 * @Author fyw
 * @Date 2022/5/8 1:19
 * @Description: 路径遍历类题目、含叶子结点的题目
 */
public class PathTraverseTemplate {
    static class Code100_101_572_617_654_671_951_965{
        // 简单题

    }
    static class Code814{
        public TreeNode pruneTree(TreeNode root) {
            if (!dfs(root)){
                root=null;
            }
            return root;
        }
        // 声明函数 实现判断以root为根的子树是否含有1的子树，不含有过程剪枝
        boolean dfs(TreeNode root){
            if (root==null)
                return false;
            if (!dfs(root.left))
                root.left=null;
            if (!dfs(root.right))
                root.right=null;
            return root.val==1||root.left!=null||root.right!=null;
        }
    }
    // LCA 865、
    static class Code235_236{
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root==null)
                return null;
            if (p==root||q==root)
                return root;
            TreeNode left=lowestCommonAncestor(root.left,p,q);
            TreeNode right=lowestCommonAncestor(root.right,p,q);
            if (left!=null&&right!=null)
                return root;
            if (left==null&&right==null)
                return null;
            return left==null?right:left;
        }
    }
    static class Code865{
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
            if (left==right)
                return root;
            if (left>right)
                return getSubTree(root.left);
            return getSubTree(root.right);
        }
    }
    static class Code1080{
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root==null){
                return null;
            }
            limit-=root.val;
            if (root.left==null&&root.right==null){
                if (limit>0){
                    root=null;
                }
            }else{
                root.left=sufficientSubset(root.left,limit);
                root.right=sufficientSubset(root.right,limit);
                if (root.left==null&&root.right==null){
                    root=null;
                }
            }
            return root;
        }
    }
    static class Code1110{
        List<TreeNode> res=new ArrayList<>();
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> set=new HashSet<>();
            for(int i:to_delete){
                set.add(i);
            }
            dfs(root,null,set);
            if (!set.contains(root.val)){
                res.add(root);
            }
            return res;
        }
        void dfs(TreeNode root, TreeNode parent, Set<Integer> set){
            if (root==null)
                return;
            dfs(root.left,root,set);
            dfs(root.right,root,set);
            if (set.contains(root.val)){
                if (parent!=null&&parent.left==root)
                    parent.left=null;
                if (parent!=null&&parent.right==root)
                    parent.right=null;
                if (root.left!=null)
                    res.add(root.left);
                if (root.right!=null)
                    res.add(root.right);
            }
        }
    }


    // 含叶子结点
    static class Code112_113{
        class Code113{
            List<List<Integer>> res=new LinkedList<>();
            public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
                backtrack(root,targetSum,new LinkedList<>());
                return res;
            }
            void backtrack(TreeNode root,int targetSum,LinkedList<Integer> path){
                if (root==null){
                    return;
                }
                targetSum-=root.val;
                path.add(root.val);
                if (root.left==null&&root.right==null){
                    if (targetSum==0){
                        res.add(new LinkedList<>(path));
                        return;
                    }
                }else{
                    if (root.left!=null){
                        backtrack(root.left,targetSum,path);
                        path.removeLast();
                    }
                    if (root.right!=null){
                        backtrack(root.right,targetSum,path);
                        path.removeLast();
                    }
                }
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
                if (ans==null||sb.toString().compareTo(ans)<0) {
                    ans=sb.toString();
                    return;
                }
                sb.reverse();
            }else{
                dfs(root.left,new StringBuilder(sb));
                dfs(root.right,new StringBuilder(sb));
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }


    static class Code513{
        int maxd=0;
        TreeNode res=null;
        public int findBottomLeftValue(TreeNode root) {
            dfs(root,1);
            return res.val;
        }
        void dfs(TreeNode root,int depth){
            if (root==null)
                return;
            if (maxd<depth){
                maxd=depth;
                res=root;
            }
            dfs(root.left,depth+1);
            dfs(root.right,depth+1);
        }
    }
    static class Code199{
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res=new ArrayList<>();
            Map<Integer,Integer> map=new HashMap<>();
            dfs(root,0,map);
            for (Map.Entry<Integer,Integer> entry:map.entrySet()){
                res.add(entry.getValue());
            }
            return res;
        }
        void dfs(TreeNode root,int depth,Map<Integer,Integer> map){
            if (root==null)
                return;
            map.put(depth,root.val);
            dfs(root.left,depth+1,map);
            dfs(root.right,depth+1,map);
        }
    }
    static class Code872{
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if (root1==null&&root2==null)
                return true;
            if (root1==null||root2==null)
                return false;
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();
            dfs(root1,list1);
            dfs(root2,list2);
            return list1.equals(list2);
        }
        void dfs(TreeNode root,List<Integer> path){
            if (root==null){
                return;
            }
            if (root.left==null&&root.right==null){
                path.add(root.val);
                return;
            }
            dfs(root.left,path);
            dfs(root.right,path);
        }
    }


    static class Code979{
        // 类似993
        public int distributeCoins(TreeNode root) {
            return dfs(root)[2];
        }
        // 二叉树中分配硬币，递归函数的定义：每棵子树对应节点数、金币数、操作数
        // 后序遍历，因为节点数、金币数、操作数必须由子树来确定
        int[] dfs(TreeNode root){
            if (root==null){
                return new int[]{0,0,0};        // 当前
            }
            int[] left=dfs(root.left);
            int[] right=dfs(root.right);
            int x=left[0]+right[0]+1;
            int y=left[1]+right[1]+root.val;
            return new int[]{x,y,Math.abs(x-y)+left[2]+right[2]};
        }
    }
    static class Code993{
        // 二叉树堂兄弟节点
        public boolean isCousins(TreeNode root, int x, int y) {
            int[] xRes=dfs(root,x,-1,0);
            int[] yRes=dfs(root,y,-1,0);
            return xRes[0]!=yRes[0]&&xRes[1]==yRes[1];
        }
        // 返回值分别为父节点和深度
        int[] dfs(TreeNode root,int cur,int father,int depth){
            if(root==null){
                return new int[]{0,0};
            }
            if (root.val==cur){
                return new int[]{father,depth};
            }
            int[] left=dfs(root.left,cur,root.val,depth+1);
            int[] right=dfs(root.right,cur,root.val,depth+1);
            return new int[]{left[0]+right[0],left[1]+right[1]};
        }
    }


    // 双重递归
    static class Code863{
        Map<TreeNode,List<TreeNode>> graph=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if (root==null){
                return Collections.emptyList();
            }
            construction(root);
            dfs(target,null,k);
            return res;
        }
        void construction(TreeNode root){
            if (root==null){
                return;
            }

            if (root.left!=null){
                graph.computeIfAbsent(root,l->new ArrayList<>()).add(root.left);
                graph.computeIfAbsent(root.left,l->new ArrayList<>()).add(root);
                construction(root.left);
            }
            if (root.right!=null){
                graph.computeIfAbsent(root,l->new ArrayList<>()).add(root.right);
                graph.computeIfAbsent(root.right,l->new ArrayList<>()).add(root);
                construction(root.right);
            }
        }
        void dfs(TreeNode root,TreeNode father,int k){
            if (k==0){
                res.add(root.val);
                return;
            }
            for (TreeNode node:graph.getOrDefault(root,new ArrayList<>())){
                if (node!=father){
                    dfs(node,root,k-1);
                }
            }
        }
    }

    static class Code297{

        StringBuilder sb=new StringBuilder();
        int u=0;
        public String serialize(TreeNode root) {
            preOrder(root);
            return sb.toString();
        }
        private void preOrder(TreeNode root){
            if (root==null){
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            preOrder(root.left);
            preOrder(root.right);
        }

        public TreeNode deserialize(String data) {
            return build(data);
        }
        TreeNode build(String data){
            if (data.charAt(u)=='#'){
                u+=2;
                return null;
            }
            int k=u;
            while (u<data.length()&&data.charAt(u)!=','){
                u++;
            }
            TreeNode root=new TreeNode(Integer.parseInt(data.substring(k,u)));
            u++;
            root.left=build(data);
            root.right=build(data);
            return root;
        }
    }
    class Code331{
        int u=0;
        public boolean isValidSerialization(String preorder) {
            preorder=preorder+",";
            if (!dfs(preorder))
                return false;
            return u==preorder.length();
        }
        boolean dfs(String preorder){
            if (u==preorder.length()){  // 递归的过程中出现了提前截止，说明不可能正确构造
                return false;
            }
            if (preorder.charAt(u)=='#'){
                u+=2;
                return true;        // 当前节点截止到空节点，可以正确构造
            }
            while (u<preorder.length()&&preorder.charAt(u)!=',')    // 截取非逗号部分
                u++;
            u++; // 跳过逗号
            return dfs(preorder)&&dfs(preorder);
        }
    }
    class Code971{
        int u=0;    // 含全局索引的题目
        List<Integer> res=new ArrayList<>();
        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            if (root==null){
                return new ArrayList<Integer>(){{add(-1);}};
            }
            if (!dfs(root,voyage))
                return new ArrayList<Integer>(){{add(-1);}};
            return res;
        }
        boolean dfs(TreeNode root,int[] v){
            if (root==null){
                return true;
            }
            if (root.val!=v[u])
                return false;
            u++;
            if (root.left!=null&&root.left.val!=v[u]){
                res.add(root.val);
                return dfs(root.right,v)&&dfs(root.left,v);
            }else{
                return dfs(root.left,v)&&dfs(root.right,v);
            }
        }
    }

    class Code1028{
        int idx=0;
        public TreeNode recoverFromPreorder(String traversal) {
            return buildTree(traversal,0);
        }
        TreeNode buildTree(String str,int depth){
            if (idx>=str.length()){
                return null;
            }
            int d=0;
            int temp=idx;
            while (str.charAt(temp)=='-'){
                temp++;
                d++;
            }
            if (d!=depth){
                return null;
            }
            idx=temp;
            int start=idx;
            while (idx<str.length()&&Character.isDigit(str.charAt(idx))){
                idx++;
            }
            int val=Integer.parseInt(str.substring(start,idx));
            TreeNode root=new TreeNode(val);
            root.left=buildTree(str,depth+1);
            root.right=buildTree(str,depth+1);
            return root;
        }
    }

}