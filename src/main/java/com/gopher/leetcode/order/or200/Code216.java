package com.gopher.leetcode.order.or200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code216
 * @Author fyw
 * @Date 2022/2/9 13:37
 * @Description: 组合总和 III
 */
public class Code216 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,n,k,new LinkedList<>());
        return res;
    }
    void dfs(int start, int n, int k, LinkedList<Integer> list){
        if(n==0){
            if(k==0){
                res.add(new LinkedList<>(list));
            }
        }else if(k!=0){
            for(int i=start;i<=9;i++){
                list.add(i);
                dfs(i+1,n-i,k-1,list);
                list.pollLast();
            }
        }


    }
}
