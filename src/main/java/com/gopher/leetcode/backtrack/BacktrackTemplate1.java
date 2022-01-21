package com.gopher.leetcode.backtrack;

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
}
