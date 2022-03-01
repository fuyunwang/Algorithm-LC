package com.gopher.leetcode.order.or120;

import com.gopher.leetcode.types.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Code199
 * @Author fyw
 * @Date 2022/2/1 19:48
 * @Description: 二叉树的右视图，前序遍历利用map中同一个键的值会覆盖的特点来存储每一层的数据
 */
public class Code199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        recur(root,0,map);
        List<Integer> res=new ArrayList<>();
        for (Integer i:map.values()){
            res.add(i);
        }
        return res;
    }
    void recur(TreeNode root, int deep, Map<Integer,Integer> map){
        if (root==null)
            return;
        map.put(deep,root.val);
        // 参数deep其实是作为key存在
        recur(root.left,deep+1,map);
        recur(root.right,deep+1,map);
    }
}
