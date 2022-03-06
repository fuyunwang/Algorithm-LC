package com.gopher.leetcode.types.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Template5
 * @Author fyw
 * @Date 2022-03-05 22:22
 * @Description 前缀和
 */
public class Template5 {
    static class Code1074{
        // 二维数组前缀和
        /**
         * 思想
         * 1. 矩阵问题可以使用二维循环固定一行来枚举后续行，从而将二维问题转换为一维问题
         * 2. 区间和-> 利用前缀和->目标值配合前缀和使用map来优化
         *
         */
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            int m=matrix.length;
            int n=matrix[0].length;
            // 预处理列前缀和
            int[][] preSum=new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    preSum[i][j]=preSum[i-1][j]+matrix[i-1][j-1];
                }
            }
            int res=0;
            for (int i = 1; i <= m; i++) {
                for (int j = i; j <= m; j++) {
                    Map<Integer,Integer> temp=new HashMap<>();
                    temp.put(0,1);
                    int sum=0;
                    // 固定好行段之后开始枚举列区间
                    for (int k = 1; k <= n; k++) {
                        sum+=preSum[j][k]-preSum[i-1][k];       // 横方向的前缀和
                        res+=temp.getOrDefault(sum-target,0);
                        temp.put(sum,temp.getOrDefault(sum,0)+1);
                    }
                }
            }
            return res;
        }
    }
}
