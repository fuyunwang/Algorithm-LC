package com.gopher.ending.backtrack;

import java.util.*;
import java.io.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022/3/12 19:19
 * @Description:
 */
public class Template1 {
    static class CodeWing1{
        // 全排列,Code
        List<List<Integer>> ans=new LinkedList<>();
        boolean[] visited;
        int n;
        public List<List<Integer>> permuteUnique(int[] nums) {
            // 必须排序放到一起
            Arrays.sort(nums);
            n=nums.length;
            visited=new boolean[n];
            backtrack(nums,new LinkedList<>());
            return ans;
        }
        void backtrack(int[] nums,LinkedList<Integer> path){
            if (path.size()==n){
                ans.add(new LinkedList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]){
                    if (i>0&&nums[i-1]==nums[i]&&!visited[i-1])
                        continue;
                    visited[i]=true;
                    path.addLast(nums[i]);
                    backtrack(nums,path);
                    path.removeLast();
                    visited[i]=false;
                }
            }
        }
    }

    static class Code332{
        // 重新安排路程
    }
}
