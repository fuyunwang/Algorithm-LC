package com.gopher.leetcode.order.or900;

import com.gopher.leetcode.types.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Title Code987
 * @Author fyw
 * @Date 2022/2/19 14:58
 * @Description: 二叉树的垂序遍历
 */
public class Code987 {
    Map<Integer,List<int[]>> map=new TreeMap<>(); // key为列，value为这一列所有元素。value中 int[]的原因是要按照行数排序。注意key之间有顺序，所以采用TreeMap
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> res=new ArrayList<>();
        for (List<int[]> value:map.values()){
            value = value.stream().sorted((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : a[0] - b[0]).collect(Collectors.toList());
            List<Integer> temp=new ArrayList<>();
            for (int[] val:value){
                temp.add(val[1]);
            }
            res.add(temp);
        }
        return res;
    }
    void dfs(TreeNode root,int x,int y){
        if (root==null)
            return;
        if (!map.containsKey(y)||map.get(y)==null){
            map.put(y,new ArrayList<>());
        }
        map.get(y).add(new int[]{x,root.val});
        dfs(root.left,x+1,y-1);
        dfs(root.right,x+1,y+1);
    }

}
