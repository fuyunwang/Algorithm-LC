package com.gopher.leetcode.order.or500;

import com.gopher.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code501
 * @Author fyw
 * @Date 2022/2/9 14:39
 * @Description: 二叉搜索树中的众数
 */
public class Code501 {

    List<Integer> res = new ArrayList<>();
    int max = 0;
    int cur = 0;
    int last ;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        if (cur == 0 || root.val == last){
            last = root.val;
            cur++;
        } else {
            cur = 1;
            last = root.val;
        }
        if (cur > max){
            res = new ArrayList<>();
            max = cur;
            res.add(last);
        } else if (cur == max) {
            res.add(last);
        }
        dfs(root.right);
    }

}
