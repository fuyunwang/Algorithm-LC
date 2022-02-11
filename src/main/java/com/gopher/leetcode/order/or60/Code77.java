package com.gopher.leetcode.order.or60;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code77
 * @Author fyw
 * @Date 2022/2/9 14:01
 * @Description: 组合
 * 经典回溯
 */
public class Code77 {
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
