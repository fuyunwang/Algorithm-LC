package com.gopher.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code39
 * @Author fyw
 * @Date 2022/1/27 16:08
 * @Description: 组合总和
 */
public class Code39 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0,new LinkedList<Integer>());
        return res;
    }
    public void backtrack(int[] candidates, int target, int ceng, LinkedList<Integer> path){
        if (target==0){
            res.add(new LinkedList<>(path));
            return;
        }
        if (ceng==candidates.length)
            return;

        for (int i = 0; candidates[ceng] * i <= target; i++) {
            backtrack(candidates,target-candidates[ceng]*i,ceng+1,path);
            path.add(candidates[ceng]);
        }

        for (int i = 0; candidates[ceng] * i <= target; i++) {
            path.pollLast();
        }
    }
}
