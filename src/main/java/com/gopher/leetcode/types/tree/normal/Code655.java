package com.gopher.leetcode.types.tree.normal;

import com.gopher.leetcode.types.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title Code655
 * @Author fyw
 * @Date 2022/2/7 18:23
 * @Description: 输出二叉树
 * 可以辅助打印
 */
public class Code655 {

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
