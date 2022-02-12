package com.gopher.leetcode.order.or100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code93
 * @Author fyw
 * @Date 2022/2/8 21:25
 * @Description: 复原IP地址
 * 本质上是如果有n个数，那么就存在n-1个分割点，取出三个位置设置分割点
 * 深度优先搜索，回溯。
 */
public class Code93 {
    List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,0,"");
        return res;
    }
    void dfs(String s,int u,int k,String path){// u表示字符串遍历的位置，k表示选择的.
        if (u==s.length()){
            if (k==4){
                res.add(path.substring(0,path.length()-1));
                return;
            }
        }
        if (k==4)
            return;
        for (int i=u,t=0;i<s.length();i++){
            if (i>u&&s.charAt(u)=='0') break;
            t=t*10+s.charAt(i)-'0';
            if(t <= 255) dfs(s,i + 1,k + 1,path + t + ".");
            else break;
        }
    }
}
