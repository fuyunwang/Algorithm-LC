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
        Arrays.sort(words, (a, b) -> a.length() - b.length());//按长度排序
        int n = words.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (check(words[j], words[i])){//word[i] 是不是word[j] 的前身
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
