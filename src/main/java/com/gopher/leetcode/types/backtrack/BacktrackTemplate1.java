package com.gopher.leetcode.types.backtrack;

import java.util.ArrayList;
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

    class Arrange2{
        // 含有重复元素的全排列
        List<List<Integer>> res=new ArrayList<>();
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            used=new boolean[nums.length];
            Arrays.sort(nums);  // 始终维持排序之后的顺序
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
                    if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
                    used[i]=true;
                    path.add(nums[i]);
                    backtrack(nums,path);
                    path.removeLast();
                    used[i]=false;
                }
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
       List<List<Integer>> res=new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            used=new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums,0,new LinkedList<>());
            return res;
        }
        void backtrack(int[] nums,int start,LinkedList<Integer> path){
            res.add(new LinkedList<>(path));
            for (int i = start; i < nums.length; i++) {
                if (!used[i]){
                    if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
                    used[i]=true;
                    path.add(nums[i]);
                    backtrack(nums,i+1,path);
                    path.removeLast();
                    used[i]=false;
                }
            }
        }
    }

    class Combine{
        class Combine1_1{
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
        class Combine1_2{
            boolean[] used;
            public int numTilePossibilities(String tiles) {
                char[] chars = tiles.toCharArray();
                Arrays.sort(chars);
                used=new boolean[chars.length];
                return backtrack(chars,0)-1;
            }
            int backtrack(char[] s,int index){
                int res=1;
                if (index==s.length) {
                    return res;
                }
                for (int i = 0; i < s.length; i++) {
                    if (!used[i]){
                        if (i>0&&s[i]==s[i-1]&&!used[i-1]) continue;
                        char t=s[i];
                        used[i]=true;
                        s[i]=' ';
                        res+=backtrack(s,index+1);
                        s[i]=t;
                        used[i]=false;
                    }
                }
                return res;
            }
        }
        class Combine1_3{
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
    }


    class Combine2{
        // 有重复数字，但是每个数字只能选一个，排序的考虑
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