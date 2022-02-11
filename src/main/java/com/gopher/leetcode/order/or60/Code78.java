package com.gopher.leetcode.order.or60;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code78
 * @Author fyw
 * @Date 2022/2/8 22:08
 * @Description: 子集
 */
public class Code78 {
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
