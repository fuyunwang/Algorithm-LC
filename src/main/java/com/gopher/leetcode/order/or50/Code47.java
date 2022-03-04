package com.gopher.leetcode.order.or50;

import java.util.*;

/**
 * @Title Code47
 * @Author fyw
 * @Date 2022/1/30 17:26
 * @Description: 含有重复元素的全排列
 */
public class Code47 {
    List<List<Integer>> res=new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,new LinkedList<>());
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> path){
        if (path.size()==nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;// 之前相同元素未使用就不能直接使用
                used[i]=true;
                path.add(nums[i]);
                backtrack(nums,path);
                path.removeLast();
                used[i]=false;
            }
        }
    }

}
