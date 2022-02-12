package com.gopher.leetcode.order.or80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code90
 * @Author fyw
 * @Date 2022/2/11 19:11
 * @Description: 含有重复元素时的子集
 * 先排序使相同的元素放到一起，回溯
 */
public class Code90 {
    List<List<Integer>> res=new LinkedList<>();
    boolean[] st;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        st = new boolean[nums.length + 10];
        dfs(nums,0,new LinkedList<>());
        return res;
    }
    //若选的话，假设上一个数与当前数一致，且上一个数没有选，则当前数一定不能选，否则会产生重复情况
    void dfs(int[] nums, int u, LinkedList<Integer> path){
        if (u==nums.length){    // u接下来要枚举的数
            res.add(new LinkedList<>(path));
            return;
        }
        dfs(nums,u+1,path);
        if(u > 0 && nums[u] == nums[u - 1] && !st[u - 1]) return;
        st[u] = true;
        path.add(nums[u]);
        dfs(nums,u + 1,path);
        path.remove(path.size() - 1);
        st[u] = false;
    }
}
