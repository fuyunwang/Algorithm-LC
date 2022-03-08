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
            /**
             * f[i]表示考虑前i本书时高度的最小值
             */
            int[] f=new int[books.length+1];
            Arrays.fill(f,Integer.MAX_VALUE);
            f[0]=0;
            for (int i = 1; i <= books.length; i++) {
                int curWidth=0;
                int curHeight=0;
                for (int j = i-1; j >=0; j--) {   // 对前i-1本书的摆放情况进行考虑。当仅第i本书放最后一层时的高度、第i-1和第i本书都放最后一层的高度、...、第1到第i本书都放最后一层的高度
                    curWidth+=books[j][0];
                    curHeight=Math.max(books[j][1],curHeight);
                    if (curWidth>shelfWidth)
                        break;
                    f[i]=Math.min(f[i],f[j]+curHeight);
                }
            }

            return f[books.length];

        }
    }
}
