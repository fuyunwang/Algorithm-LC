package com.gopher.leetcode.order.or300;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code386
 * @Author fyw
 * @Date 2022/2/9 14:46
 * @Description: 字典序排数
 * 10叉数先序遍历
 */
public class Code386 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<=9;i++){
            dfs(i,n);
        }
        return res;
    }

    public void dfs(int cur,int n){
        if(cur>n) return;
        res.add(cur);
        for(int i=0;i<=9;i++){
            dfs(cur*10+i,n);
        }
    }
}
