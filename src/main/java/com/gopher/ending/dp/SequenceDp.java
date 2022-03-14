package com.gopher.ending.dp;

import java.util.*;

/**
 * @Title SequenceDp
 * @Author fyw
 * @Date 2022-03-12 12:42
 * @Description
 */
public class SequenceDp {
    static class Code629{
        // f[i,j] 表示所有前1~i个字符中包含j个逆序对的排列数的最大值

    }
    static class Code813{
        // 最大平均值和分组
        public double largestSumOfAverages(int[] nums, int m) {
            // 1 线性dp经典题，f(i,j)表示将前i个元素分为j段的最大分数。考虑最后一段的长度可以是1..i - 1，即对应下标k
            // 2 k的范围是[0, i - 1] ,则f(i,j) = max(f(k, j - 1) + (si - sk) / (i - k))
            // 3 后面一段可以用前缀和快速求出
            double[][] dp = new double[nums.length + 1][m + 1];
            for (int i = 0; i <= nums.length; i++) Arrays.fill(dp[i], -1e8); // 注意初始化为负数
            dp[0][0] = 0; // 初始值为0
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) sum[i] = sum[i - 1] + nums[i - 1];
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + (sum[i] - sum[k]) / (double)(i - k));
                    }
                }
            }
            return dp[nums.length][m];
        }
    }
    static class Code712{
        // 两个字符串的最小ASCII删除和、最长公共子序列、最长公共超序列都是一类题目
        public int minimumDeleteSum(String s1, String s2) {
            int n = s1.length() ;
            int m = s2.length();
            int [][] f = new int [n + 1][m + 1] ;
            //当某个串长度为0的话，是不能删除其串的
            for (int i = 1 ; i <= m ; ++i)
                f[0][i] = f[0][i - 1] + (int)s2.charAt(i - 1)  ;

            for (int i= 1; i <= n ; ++i)
                f[i][0] = f[i - 1][0] + (int)s1.charAt(i - 1) ;

            s1=" "+s1; s2=" "+s2;
            for (int i = 1; i <= n ;++i)
                for (int j = 1;  j <= m ; ++j)
                    if (s1.charAt(i) == s2.charAt(j))
                        f[i][j] = f[i - 1][j - 1] ;
                    else{
                        int v1=f[i - 1][j] + (int)(s1.charAt(i));
                        int v2=f[i][j - 1] + (int)(s2.charAt(j));
                        int v3=f[i-1][j-1]+(int)(s1.charAt(i))+(int)(s2.charAt(j));
                        f[i][j]=Math.min(v1,Math.min(v2,v3));
                    }

            return f[n][m];
        }
    }
    static class Code960{
        // 删列造序
        public int minDeletionSize(String[] strs) {
            int n = strs.length, m = strs[0].length();
            int[] f = new int[m];
            int res = m;

            for (int i = 0; i < m; ++i) {
                f[i] = i;
                for (int j = 0; j < i; ++j) {
                    if (check(strs, j, i)) {
                        f[i] = Math.min(f[i], f[j] + i - j - 1);
                    }
                }
                res = Math.min(res, f[i] + m - 1 - i);
            }
            return res;
        }

        private boolean check(String[] strs, int j, int i) {
            int n = strs.length;
            for (int k = 0; k < n; ++k) {
                if (strs[k].charAt(j) > strs[k].charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
