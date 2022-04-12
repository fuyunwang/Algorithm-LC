package com.gopher.leetcode.order.or1000;

import java.util.Arrays;

/**
 * @Title Code1048
 * @Author fyw
 * @Date 2022/2/9 13:36
 * @Description: 最长字符串链
 * 拓扑图求解最长路用递推、模板题
 */
public class Code1048 {
    // 判断一个字符串a是否是字符串b的前身
        // a.length<b.length
        // a是b的子序列
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());//按长度排序
        int n=words.length;
        int[] f=new int[n]; // 前i个字符串的最长字符串链长度
        int res=0;
        for(int i=0;i<n;i++){
            f[i]=1;
            for(int j=0;j<i;j++){   // 每次遍历之前的字符串来更新长度
                if(check(words[j],words[i])){
                    f[i]=Math.max(f[i],f[j]+1);
                }
            }
            res=Math.max(res,f[i]);
        }
        return res;
    }
    boolean check(String a,String b){
        if(a.length()+1!=b.length()){
            return false;
        }
        int idx=0;
        for(int i=0;i<b.length();i++){
            if(idx<a.length()&&a.charAt(idx)==b.charAt(i)){
                idx++;
            }
        }
        return idx==a.length();
    }
}
