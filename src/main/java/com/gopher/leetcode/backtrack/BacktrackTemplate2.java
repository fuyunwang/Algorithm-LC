package com.gopher.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title BacktrackTemplate2
 * @Author fyw
 * @Date 2022/1/29 20:09
 * @Description: 组合总和、
 */
public class BacktrackTemplate2 {
    //组合总和1,2,3,4
    class Code39{
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
    class Code40{
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
    class Code216{
        // 搜索组合问题要避免重复，定义一个顺序

    }
}
