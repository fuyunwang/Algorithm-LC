package com.fuyunwang.bilibili.order.subseq;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code491
 * @Author fyw
 * @Date 2022-05-26 15:38
 * @Description
 */
public class Code491 {
    boolean[] visited;
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        visited=new boolean[nums.length];
        backtrack(nums,0,new LinkedList<>());
        return res;
    }
    void backtrack(int[] nums,int start,LinkedList<Integer> path){
        if (path.size()>=2)
            res.add(new LinkedList<>(path));
        if (start== nums.length)
            return;
        HashSet<Integer> set=new HashSet<>();
        for (int i = start; i <nums.length ; i++) { // 本题不一定有序，去重的方式要改变
            if (set.contains(nums[i]))
                continue;
            set.add(nums[i]);
//               if (!visited[i]){
//                   if (i>0&&!visited[i-1]&&nums[i]==nums[i-1]){
//                       continue;
//                   }
            if (path.isEmpty()||path.peekLast()<=nums[i]){
                visited[i]=true;
                path.addLast(nums[i]);
                backtrack(nums,i+1,path);
                visited[i]=false;
                path.removeLast();
            }
//               }
        }
    }
}
