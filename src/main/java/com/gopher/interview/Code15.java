package com.gopher.interview;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.*;

/**
 * @Title Code15
 * @Author fyw
 * @Date 2022-02-22 10:50
 * @Description 二叉树遍历
 * 包含n个不同节点的二叉树有卡特兰数个
 */
public class Code15 {
    static class Code1{
        // 中序遍历和层序遍历重建二叉树，思路是以层序遍历为主，配合中序遍历找到每个访问节点的索引，然后减一判断左子节点是否存在，加一判断右子节点是否存在
        public static void main(String[] args) {
            // 初始化数据
            Scanner sc = new Scanner(System.in);
            String inorder = sc.nextLine();
            String lorder = sc.nextLine();
            Map<Character, Integer> pos = new HashMap<>();
            for (int i  = 0; i < inorder.length(); i++) {
                pos.put(inorder.charAt(i), i);  // 存中序遍历的数据和索引对应，方便后续取
            }
            int[] visited = new int[26];        // 字符串的长度范围在26以内，默认未访问过都是0

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(lorder.charAt(0));
            queue.offer(root);

            int index = 1;                          // index表示层序遍历的索引
            while (index < lorder.length()) {
                TreeNode parent = queue.poll();
                int posIndex = pos.get(parent.val); // 从中序遍历找到当前根节点的索引
                visited[posIndex] = 1;
                if (posIndex > 0 && visited[posIndex - 1] == 0) {
                    parent.left = new TreeNode(lorder.charAt(index++));
                    queue.offer(parent.left);
                }

                if (posIndex < lorder.length() - 1 && visited[posIndex + 1] == 0) {
                    parent.right = new TreeNode(lorder.charAt(index++));
                    queue.offer(parent.right);
                }
            }
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            System.out.println(sb);

        }

        public static void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val);
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
    }

    // 重建二叉树
    // 序列化与反序列化

}