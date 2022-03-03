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
    // 顺序不同的序列被视作不同的组合。
    static class Code377{
        // 状态表示：定义f[i][j]为组合长度为i，凑成总和为j的方案数是多少。由于对组合方案的长度没有限制，因此我们最终答案为所有的f[x][target]的总和。
        // 状态计算：那么对任意的f[len][target]而言，组合中的最后一个数字可以选择nums中的任意数值。 f[len][target]=f[len-1][target-nums[0]]+f[len-1][target-nums[1]]+...
        public int combinationSum4(int[] nums, int target) {
            // 因为 nums[i] 最小值为 1，因此构成答案的最大长度为 target
            int len=target;
            int[][] f=new int[len+10][target+10];
            f[0][0]=1;
            int res=0;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j <= target; j++) {
                    for (int k = 0; k < nums.length; k++) {
                        // 做选择，target的值需要存储下nums[k]才可，完全背包
                        if (j>=nums[k]){
                            f[i][j]=f[i][j]+f[i-1][j-nums[k]];
                        }
                    }
                }
                res+=f[i][target];
            }
            return res;
        }
    }

    static class Code1995{
        // 统计特殊四元组
        // 利用等式关系 nums[a] + nums[b] + nums[c] = nums[d]，具有明确的「数值」和「个数」关系，可将问题抽象为组合优化问题求方案数。
    }
}
