package com.gopher.ending.structure.tree;

import com.gopher.leetcode.types.structure.linkedlist.ListNode;
import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Construction
 * @Author fyw
 * @Date 2022/4/17 2:02
 * @Description:
 */
public class Construction {
    // 枚举可能性
    static class Code894{

    }
    static class Code95{

    }


    static class Code450{
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root==null)
                return null;
            if (root.val<key){
                root.right=deleteNode(root.right,key);
            }else if (root.val>key){
                root.left=deleteNode(root.left,key);
            }else{
                if (root.left==null) return root.right;
                if (root.right==null) return root.left;
                TreeNode node=root.right;
                while (node.left!=null){
                    node=node.left;
                }
                node.left=root.left;
                return root.right;
            }
            return root;
        }
    }
    static class Code637{
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1==null&&root2==null){
                return null;
            }
            if (root1==null){
                return root2;
            }
            if (root2==null){
                return root1;
            }
            root1.val+=root2.val;
            root1.left=mergeTrees(root1.left,root2.left);
            root1.right=mergeTrees(root1.right,root2.right);
            return root1;
        }
    }
    static class Code998{
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root==null){
                return new TreeNode(val);
            }
            if (root.val<val){
                TreeNode node=new TreeNode(val);
                node.left=root;
                return node;
            }else{
                root.right=insertIntoMaxTree(root.right,val);
            }
            return root;
        }
    }
    // 二叉树与链表
    static class Code114{
        TreeNode pre=null;
        public void flatten(TreeNode root) {    // 遍历返回结果是逆序所以拼接之前的节点
            if (root==null)
                return;
            flatten(root.right);
            flatten(root.left);
            root.right=pre;
            root.left=null;
            pre=root;
        }
    }
    static class Code897{
        TreeNode tail;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummyHead=new TreeNode(-1);
            tail=dummyHead;
            dfs(root);
            return dummyHead.right;
        }
        void dfs(TreeNode root){
            if (root==null)
                return;
            dfs(root.left);
            tail.right=root;
            root.left=null;
            tail=tail.right;
            dfs(root.right);
        }
    }


    // 树结构的存储与转化
    class Code105{
        // 前序和中序遍历构造二叉树
        Map<Integer,Integer> map=new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return build(preorder,inorder,0,preorder.length,0,inorder.length-1);
        }
        TreeNode build(int[] preorder,int[] inorder,int pl,int pr,int il,int ir){
            if (pl>pr||il>ir)
                return null;
            int mid=map.get(preorder[pl]);
            TreeNode root=new TreeNode(preorder[pl]);
            int num=mid-il;
            root.left=build(preorder,inorder,pl+1,pl+num,il,mid-1);
            root.right=build(preorder,inorder,pl+1+num, pr,mid+1,ir);
            return root;
        }
    }
    class Code106{
        // 中序和后序遍历构造二叉树
        Map<Integer,Integer> map=new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        }
        TreeNode build(int[] inorder,int[] postorder,int il,int ir,int pl,int pr){
            if (il>ir||pl>pr)
                return null;
            TreeNode root=new TreeNode(postorder[pr]);
            int index=map.get(postorder[pr]);
            int leftNum=index-il;
            int rightNum=ir-index;

            root.left=build(inorder,postorder,il,index-1,pl,pl+leftNum-1);
            root.right=build(inorder,postorder,index+1,ir,pl+leftNum,pl+leftNum+rightNum-1);

            return root;

        }
    }
    class Code889{
        // 前序和后序遍历构造二叉树
    }
    class Code297{
        // 二叉树的序列化和反序列化
        StringBuilder sb=new StringBuilder();
        int u=0;
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            preOrder(root);
            return sb.toString();
        }
        void preOrder(TreeNode root){
            if (root==null){
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            preOrder(root.left);
            preOrder(root.right);
        }

        // Decodes your encoded data to tree.
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
    class Code1028{ // 全局索引，类似Code971翻转二叉树匹配先序遍历
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
    class Code652{
        List<TreeNode> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            return res;
        }
        String dfs(TreeNode root){
            if (root==null){
                return "#";
            }
            String path=String.valueOf(root.val)+",";
            path+=dfs(root.left)+",";
            path+=dfs(root.right);
            map.put(path,map.getOrDefault(path,0)+1);
            if (map.get(path)==2){
                res.add(root);
            }
            return path;
        }
    }
    class Code971{
        // 类似331
        int u=0;
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
    class Code331{
        // 验证前序遍历
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
    class Code449{
        // 序列化BST反序列化
    }
}