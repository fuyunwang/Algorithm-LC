package com.gopher.leetcode.order.or400;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code491
 * @Author fyw
 * @Date 2022/2/13 18:11
 * @Description: 递增子序列
 * 类似子集
 */
public class Code491 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums==null||nums.length==0)
            return Collections.emptyList();
        backtrack(nums,new LinkedList<>(),0);
        return res;
    }
    public void backtrack(int[] nums,LinkedList<Integer> path,int start){
        if (path.size()>=2)
            res.add(new LinkedList<>(path)); // 类似子集，要在中间状态满足时就加入结果
        if (start==nums.length)
            return;
        HashSet<Integer> set=new HashSet<>(); //在当前这一层的时候，重复的同一个元素加入一次（注意每次创建新的，同样元素但不是同一个不会重复），使用set辅助实现操作
        for (int i = start; i < nums.length; i++) {
            if (path.isEmpty()||path.getLast()<=nums[i]){
                if (set.contains(nums[i]))
                    continue;
                set.add(nums[i]);
                path.addLast(nums[i]);
                backtrack(nums,path,i+1); // 注意此处是i+1
                path.pollLast();
            }
        }
    }
}
