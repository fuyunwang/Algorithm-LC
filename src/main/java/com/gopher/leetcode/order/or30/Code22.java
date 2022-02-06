package com.gopher.leetcode.order.or30;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code22
 * @Author fyw
 * @Date 2022/1/23 11:55
 * @Description: 括号生成
 */
public class Code22 {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,0,0,"");
        return res;
    }
    public void dfs(int n,int l,int r,String state){
        if (l==n&&r==n){
            res.add(state);
            return;
        }
        if (l<n){
            dfs(n,l+1,r,state+"(");
        }
        if (r<n&&r<l){
            dfs(n,l,r+1,state+")");
        }
    }
}
