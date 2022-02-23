package com.gopher.leetcode.order.or50;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code46
 * @Author fyw
 * @Date 2022/2/8 21:49
 * @Description: 全排列
 */
public class Code46 {
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
