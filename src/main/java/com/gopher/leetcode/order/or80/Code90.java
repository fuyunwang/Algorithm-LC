package com.gopher.leetcode.order.or80;

import java.util.*;

/**
 * @Title Code90
 * @Author fyw
 * @Date 2022/2/11 19:11
 * @Description: 含有重复元素时的子集
 * 先排序使相同的元素放到一起，回溯
 * 注意set的使用，一个是在回溯中保证同一个元素（注意重复元素不一定是同一个元素，这里指的还是位置）只有一个，外部的set保证集合中不会重复，配合排序使用
 */
public class Code90 {
    List<List<Integer>> res=new LinkedList<>();
    Set<List<Integer>> temp=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new LinkedList<>());
        for (List<Integer> list:temp){
            res.add(list);
        }
        return res;
    }
    void dfs(int[] nums, int u, LinkedList<Integer> path){
        temp.add(new LinkedList<>(path));
        if (u==nums.length)
            return;
        HashSet<Integer> set=new HashSet<>();
        for (int i = u; i < nums.length; i++) {
            if (set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            path.addLast(nums[i]);
            dfs(nums,i+1,path);
            path.pollLast();
        }
    }
}
