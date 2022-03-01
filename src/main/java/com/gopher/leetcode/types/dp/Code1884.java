package com.gopher.leetcode.types.dp;

/**
 * @Title Code1884
 * @Author fyw
 * @Date 2022/2/14 19:25
 * @Description: 鸡蛋掉落
 */
public class Code1884 {
    // 解法1
    class Solution {
        // f[i][j]表示i层楼，j个鸡蛋的测量方案中最坏情况的最小值。注意是最坏情况，因为鸡蛋碎与不碎是可能的情况，我们要按照最差的来
        int[][] f=new int[1001][3];
        public int twoEggDrop(int n) {  // n层楼
            int m=2;    // 表示有两个鸡蛋
            for (int i = 1; i <= n; i ++ ) f[i][1] = i; // 一个鸡蛋要是测楼的高度，最差情况是每层楼都扔一下测试
            for (int i = 1; i <= m; i ++ ) f[1][i] = 1; // 多个鸡蛋，一层楼，最差情况也只需要一个鸡蛋就能测出来了
            // 状态转移方程：分为使用第j个鸡蛋和不使用第j个鸡蛋
            // 如果不使用第j个鸡蛋就能测出，那么f[i][j]=f[i][j-1]
            // 如果使用第j个鸡蛋，那么在1~i层楼选择扔，如果在第k层楼扔了，
            // 如果此时的结果是蛋碎了，那么应该在1~k-1层测试，并且鸡蛋的个数少了一个，并且接下来只能一层层的测试:f[(k-1)-1+1][j-1]即f[k-1][j-1]
            // 否则在k+1~i测试，并且鸡蛋的个数没少:f[i-(k+1)+1][j]即f[i-k][j]
            // 状态转移方程：f[n]=min1+max(k−1,f[n−k])
            for (int i = 2; i <= n; i ++ )
                for (int j = 2; j <= m; j ++ ) {
                    f[i][j] = f[i][j - 1];
                    for (int k = 1; k <= i; k ++ )
                        f[i][j] = Math.min(f[i][j],Math.max(f[k - 1][j - 1], f[i - k][j]) + 1);
                }

            return f[n][m];
        }
    }
}
