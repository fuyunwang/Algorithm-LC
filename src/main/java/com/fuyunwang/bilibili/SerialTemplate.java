package com.fuyunwang.bilibili;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.*;

/**
 * @Title SerialTemplate
 * @Author fyw
 * @Date 2022/5/8 1:16
 * @Description: 与序列化反序列化、基于遍历构造二叉树相关的题目
 */
public class SerialTemplate {
    static class Code105{
        Map<Integer,Integer> map=new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return dfs(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        }
        public TreeNode dfs(int[] preorder,int[] inorder,int pl,int pr,int il,int ir){
            if (pl>pr||il>ir)
                return null;
            int rootVal=preorder[pl];
            TreeNode root=new TreeNode(rootVal);
            int mid=map.get(rootVal);
            int num=mid-il;
            root.left=dfs(preorder,inorder,pl+1,pl+num,il,mid-1);
            root.right=dfs(preorder,inorder,pl+1+num,pr,mid+1,ir);
            return root;
        }
    }
    static class Code106{
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
    static class Code889{
        Map<Integer,Integer> map=new HashMap<>();
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            for (int i = 0; i < post.length; i++) {
                map.put(post[i],i);
            }
            return helper(pre,post,0,pre.length-1,0,post.length-1);
        }
        public TreeNode helper(int[] pre,int[] post,int prestart,int preend,int poststart,int postend){
            if (prestart>preend)
                return null;
            TreeNode root=new TreeNode(pre[prestart]);
            if (preend==prestart)
                return root;
            int idx=map.get(pre[prestart+1]);
            int leftNum=idx-poststart;
            root.left=helper(pre,post,prestart+1,prestart+leftNum+1,poststart,idx);
            root.right=helper(pre,post,prestart+leftNum+2,preend,idx+1,postend-1);
            return root;
        }
    }


    static class Code606{
        // 类似括号生成
        public String tree2str(TreeNode root) {
            if (root==null){
                return "";
            }
            return dfs(root,new StringBuilder());
        }
        String dfs(TreeNode root,StringBuilder sb){
            if (root==null){
                return sb.toString();
            }
            sb.append(root.val);
            if (root.left!=null){
                sb.append("(");
                sb.append(dfs(root.left,new StringBuilder()));
                sb.append(")");
            }
            if (root.left==null&&root.right!=null){
                sb.append("()");
                sb.append("(");
                sb.append(dfs(root.right,new StringBuilder()));
                sb.append(")");
            }
            if (root.left!=null&&root.right!=null){
                sb.append("(");
                sb.append(dfs(root.right,new StringBuilder()));
                sb.append(")");
            }
            return sb.toString();
        }
    }


    static class Code449{   // 序列化与反序列化二叉搜索树
        public class Codec {
            public String serialize(TreeNode root) {
                if(root==null){
                    return "#";
                }
                return root.val+","+serialize(root.left)+","+serialize(root.right);
            }
            public TreeNode deserialize(String data) {
                String[] s1 = data.split(",");
                List<Integer> s = new ArrayList<Integer>();
                for(int i = 0;i < s1.length;i ++)
                {
                    if(s1[i].equals("#")) continue;
                    s.add(Integer.parseInt(s1[i]));
                }
                return dfs(s, 0, s.size() - 1);
            }

            TreeNode dfs(List<Integer> s, int l, int r) {
                if(l > r) return null;
                //选取第一个为根结点
                TreeNode root = new TreeNode(s.get(l));
                //找到第一个比root.val大的元素的位置
                int idx = l + 1, p = s.get(l);
                while(idx <= r && s.get(idx) < p) idx ++;
                root.left = dfs(s, l + 1, idx - 1);
                root.right = dfs(s, idx, r);
                return root;
            }

        }
    }

    static class Code331{   // 验证二叉树的前序序列化
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

    static class Code652{
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

    static class Code655{
        String temp[][];

        public List<List<String>> printTree(TreeNode root) {
            if (root==null)
                return Collections.emptyList();
            final int[] heightAndWidth = getHeightAndWidth(root);
            int h=heightAndWidth[0];
            int w=heightAndWidth[1];
            temp=new String[h][w];
            print(root,0,0,w-1);
            List<List<String>> res=new ArrayList<>();
            for (String[] s:temp){
                List<String> list=new ArrayList<>();
                for (int i = 0; i < s.length; i++) {
                    list.add(s[i]==null?"":s[i]);
                }
                res.add(list);
            }
            return res;
        }

        public void print(TreeNode root, int h, int l, int r) {
            if (root==null)
                return;
            int mid=(l+r)/2;
            temp[h][mid] = String.valueOf(root.val);
            print(root.left, h + 1, l, mid - 1);
            print(root.right, h + 1, mid + 1, r);
        }

        // 计算树的宽和高
        public int[] getHeightAndWidth(TreeNode root){
            if (root==null)
                return new int[]{0,0};
            return new int[]{
                    Math.max(getHeightAndWidth(root.left)[0],getHeightAndWidth(root.right)[0])+1,
                    Math.max(getHeightAndWidth(root.left)[1],getHeightAndWidth(root.right)[1])*2+1
            };
        }
    }

    static class Code971{

    }

    static class Code1028{

    }
}
