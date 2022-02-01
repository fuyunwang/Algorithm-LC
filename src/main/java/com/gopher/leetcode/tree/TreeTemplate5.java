package com.gopher.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title TreeTemplate5
 * @Author fyw
 * @Date 2022/2/1 21:26
 * @Description: 二叉树的序列化相关
 */
public class TreeTemplate5 {
    // 二叉树展开为链表
    TreeNode pre=null;
    public void flatten(TreeNode root) {
        if (root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }

    // 二叉树的序列化和反序列化
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null){
                return "#";
            }
            return root.val + " " + serialize(root.left) + " " +serialize(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            final String[] strs = data.split(" ");
            List<TreeNode> list=new LinkedList<>();
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].equals("#")){
                    list.add(new TreeNode(Integer.valueOf(strs[i])));
                }else{
                    list.add(null);
                }
            }
            return mydeserialize(list);
        }
        public TreeNode mydeserialize(List<TreeNode> list){
            if (list.isEmpty()){
                return null;
            }
            final TreeNode root = list.get(0);
            list.remove(0);
            if (root==null){
                return null;
            }
            root.left=mydeserialize(list);
            root.right=mydeserialize(list);
            return root;
        }
    }

}
