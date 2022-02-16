package com.gopher.leetcode.order.or200;

import com.gopher.leetcode.tree.TreeNode;

/**
 * @Title Code297
 * @Author fyw
 * @Date 2022/2/9 14:05
 * @Description: 二叉树的序列化和反序列化
 */
public class Code297 {
    public class Codec {
        StringBuilder sb = new StringBuilder();
        int u = 0;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            preOrder(root);
            return sb.toString();
        }

        private void preOrder(TreeNode root) {
            if (root == null) {
                sb.append("#,");
                return;
            }

            sb.append(root.val).append(",");
            preOrder(root.left);
            preOrder(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return dfs(data);
        }

        private TreeNode dfs(String data) {
            if (data.charAt(u) == '#') {
                u += 2;
                return null;
            }

            int j = u;
            while(data.charAt(u) != ',') {
                u++;
            }
            TreeNode root = new TreeNode(Integer.valueOf(data.substring(j, u)));
            //跳过,
            u++;
            root.left = dfs(data);
            root.right = dfs(data);
            return root;
        }

    }
}
