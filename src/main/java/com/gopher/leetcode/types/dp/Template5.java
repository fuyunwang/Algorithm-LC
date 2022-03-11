package com.gopher.leetcode.types.dp;

/**
 * @Title Template5
 * @Author fyw
 * @Date 2022-03-09 15:25
 * @Description 状态压缩DP 状态选择DP
 */
public class Template5 {
    static class Code935{
        public int knightDialer(int n) {
            //dp[i][j] 跳了i次最后位于j的方案数
            int[][] dp = new int [n][10];
            for (int i = 0; i < 10; i++) dp[0][i] = 1;
            int MOD = 1000000007;
            int[][] tr = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
            for (int i = 1; i< n; i++){
                for (int j = 0; j < 10; j++){
                    for (int k:tr[j]){
                        dp[i][j] = (dp[i][j] + dp[i - 1][k])%MOD;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < 10; i++){
                res = (res + dp[n - 1][i])%MOD;
            }
            return res;
        }
    }
}
