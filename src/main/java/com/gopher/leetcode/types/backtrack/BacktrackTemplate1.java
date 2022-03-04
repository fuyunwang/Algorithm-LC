package com.gopher.leetcode.types.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title BacktrackTemplate1
 * @Author fyw
 * @Date 2022/1/21 20:08
 * @Description: 回溯算法模板1，全排列，子集，组合
 */
public class BacktrackTemplate1 {
    class Arrange{
        List<List<Integer>> result=new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> temp=new LinkedList<>();
            backtrack(nums,temp);
            return result;
        }
        public void backtrack(int[] nums,LinkedList<Integer> list){
            if (nums.length==list.size()){
                result.add(new LinkedList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                backtrack(nums,list);
                list.pollLast();
            }
        }
    }

    class Subsets{
        LinkedList<List<Integer>> result=new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            LinkedList<Integer> temp=new LinkedList<>();
            backtrack(nums,temp,0);
            return result;
        }
        public void backtrack(int[] nums,LinkedList<Integer> list,int start){
            result.add(new LinkedList<>(list));
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                backtrack(nums,list,i+1);
                list.pollLast();
            }
        }
    }

    class Subsets2{
       // 重复元素
    }

    class Combine{
        List<List<Integer>> result=new LinkedList<>();
        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> temp=new LinkedList<>();
            backtrack(n,temp,1,k);
            return result;
        }
        public void backtrack(int n,LinkedList<Integer> list,int start,int k){
            if (list.size()==k){
                result.add(new LinkedList<>(list));
                return;
            }
            for (int i = start; i <= n; i++) {
                list.add(i);
                backtrack(n,list,i+1,k);
                list.pollLast();
            }
        }
    }
    class Combine2{
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
    class Combine3{
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
    class Combine4{
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

}
