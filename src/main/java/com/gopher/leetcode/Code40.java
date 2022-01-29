package com.gopher.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code40
 * @Author fyw
 * @Date 2022/1/29 20:36
 * @Description:
 */
public class Code40 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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

        // 计算当前所选元素的个数，在此之前数组务必排序
        int k=ceng+1;
        while (k<candidates.length&&candidates[k]==candidates[ceng]) k++;
        int cnt=k-ceng;

        for (int i = 0; candidates[ceng] * i <= target&&i<=cnt; i++) {
            backtrack(candidates,target-candidates[ceng]*i,k,path);
            path.add(candidates[ceng]);
        }

        for (int i = 0; candidates[ceng] * i <= target&&i<=cnt; i++) {
            path.pollLast();
        }
    }
}
