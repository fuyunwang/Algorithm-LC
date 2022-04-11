package com.gopher.leetcode.types.dp;

import java.util.Arrays;

/**
 * @Title Template3
 * @Author fyw
 * @Date 2022-03-04 9:39
 * @Description
 */
public class Template3 {

    static class Code746{
        public int minCostClimbingStairs(int[] cost) {
            int n=cost.length;
            int[] dp=new int[n+1];
            for (int i = 2; i <= n; i++) {
                dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
            }
            return dp[n];
        }
    }

    static class Code1105{
        // 题意是要求把所有书摆放到所有书架上，要求每一层书架的厚度能容纳当前层数的总厚度同时书架的总高度最小
        public int minHeightShelves(int[][] books, int shelfWidth) {
            int n=books.length;
            int[] f=new int[n+1]; // 考虑前i本书摆放方案的高度最小值
            Arrays.fill(f,Integer.MAX_VALUE);
            f[0]=0;
            for (int i = 1; i <= n; i++) {  // 递推计算要枚举每一本书作为最后一本书的情况
                int height=0;
                int width=0;
                for (int j = i-1; j >= 0; j--) {    // 最后一层摆放第i本（索引是i-1）、第i和i-1本、。。。。
                    width+=books[j][0];
                    height=Math.max(height,books[j][1]);
                    if (width>shelfWidth)
                        break;
                    f[i]=Math.min(f[i],f[j]+height);    // 注意这里的索引又是另外一码事
                }
            }
            return f[n];
        }
    }
}
