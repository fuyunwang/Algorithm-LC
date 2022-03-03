package com.gopher.leetcode.types.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-03 16:45
 * @Description
 */
public class Template2 {
    static class Code39{
        // 同一个数字可以无限选取
        List<List<Integer>> res=new LinkedList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates,0,target,new LinkedList());
            return res;
        }
        void backtrack(int[] candidates, int u, int target, LinkedList path){    // 选择列表，u表示当前枚举的索引，target表示剩余的值
            if (target==0){
                res.add(new LinkedList<>(path));
                return;
            }
            if (u==candidates.length) return;

            // 开始枚举，注意从0个到多个的枚举实现是后序遍历，这里的i是数量
            for (int i = 0; i*candidates[u] <= target; i++) {
                backtrack(candidates,u+1,target-i*candidates[u],path);
                path.addLast(candidates[u]);
            }
            for (int i = 0; i*candidates[u] <= target; i++) {
                path.pollLast();//恢复现场
            }
        }
    }
    static class Code40{
        // 有重复数字，但是每个数字只能选一个
        List<List<Integer>> res=new LinkedList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);        // 排序方便所有数放在一块
            backtrack(candidates,0,target,new LinkedList());
            return res;
        }
        void backtrack(int[] candidates, int u, int target, LinkedList path){    // 选择列表，u表示当前枚举的索引，target表示剩余的值
            if (target==0){
                res.add(new LinkedList<>(path));
                return;
            }
            if (u==candidates.length) return;

            // 找到当前相同数的个数
            int k=u+1;
            while (k<candidates.length&&candidates[k]==candidates[u]) k++;
            int count=k-u;

            // 开始枚举，注意从0个到多个的枚举实现是后序遍历，这里的i是数量
            for (int i = 0; i*candidates[u] <= target&&i<=count; i++) {
                backtrack(candidates,k,target-i*candidates[u],path);
                path.addLast(candidates[u]);
            }
            for (int i = 0; i*candidates[u] <= target&&i<=count; i++) {
                path.pollLast();//恢复现场
            }
        }
    }
    static class Code77{
        List<List<Integer>> res=new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            backtrack(1,n,k,new LinkedList<>());
            return res;
        }
        void backtrack(int start,int n,int k,LinkedList<Integer> path){
            if (k==0){
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = start; i <= n; i++) {
                path.addLast(i);
                backtrack(i+1,n,k-1,path);
                path.pollLast();
            }
        }
    }
    static class Code216{
        // 无重复数字，每个数字只能选一次，顺序的考虑
        List<List<Integer>> res=new LinkedList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            backtrack(1,n,k,new LinkedList<>());//从1开始枚举，n为剩余数，k为个数
            return res;
        }
        void backtrack(int start,int target,int count,LinkedList<Integer> path){
            if (target==0){
                if (count==0){
                    res.add(new LinkedList<>(path));
                    return;
                }
            }else if (count>0){
                for (int i = start; i <= 9; i++) {
                    path.addLast(i);
                    backtrack(i+1,target-i,count-1,path);
                    path.pollLast();
                }
            }
        }
    }
    static class Code377{
        // 顺序不同的序列被视作不同的组合。
        // 状态表示： f[i][j]:所有从前i个位置中选，且总体积恰好是j的所有方案
        // 状态计算： f[i][j] = f[i][j] + f[i - 1][j - a(k)]
    }
}
