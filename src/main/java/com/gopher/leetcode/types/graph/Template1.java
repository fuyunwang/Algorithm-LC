package com.gopher.leetcode.types.graph;

import java.util.Arrays;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-06 20:56
 * @Description
 */
public class Template1 {
    static class Code1048{
        // 拓扑图求最长路用递推的方法
        // 一个字符串是另一个字符串的前身
        private boolean check(String a, String b){  // 双指针统计来判断子序列
            if (a.length() + 1 != b.length()){
                return false;
            }
            int i = 0;
            for (char c:b.toCharArray()){
                if (i < a.length() && a.charAt(i) == c){
                    i++;
                }
            }
            return i == a.length();
        }
        public int longestStrChain(String[] words) {
            // 首先排序
            Arrays.sort(words,(a,b)->a.length()-b.length());
            int res=0;
            int n=words.length;
            int[] f=new int[n];
            for (int i = 0; i < n; i++) {
                f[i]=1; // 长度最少包含自己
                for (int j = 0; j < i; j++) {
                    if (check(words[j],words[i])){
                        f[i]=Math.max(f[i],f[j]+1);
                    }
                }
                res=Math.max(res,f[i]);
            }
            return res;
        }
    }
}
