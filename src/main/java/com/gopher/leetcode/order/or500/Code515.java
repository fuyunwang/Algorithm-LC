package com.gopher.leetcode.order.or500;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Code515
 * @Author fyw
 * @Date 2022/2/17 19:51
 * @Description: 在每个树行中找最大值
 * 类似513题目
 */
public class Code515 {
    Map<Integer,Integer> max=new HashMap<>();       // 存每一层的最大值
    int maxDepth;
    public List<Integer> largestValues(TreeNode root) {
        dfs(root,1);
        List<Integer> res=new ArrayList<>();
        for (int i = 1; i <= maxDepth; i++) {
            res.add(max.get(i));
        }
        return res;
    }
    void dfs(TreeNode root,int depth){
        if (root==null)
            return;
        // 记录下层数
        if (depth>maxDepth){
            maxDepth=depth;
        }
        if (!max.containsKey(depth)) max.put(depth,root.val);
        else{
            max.put(depth,Math.max(max.get(depth),root.val));
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
