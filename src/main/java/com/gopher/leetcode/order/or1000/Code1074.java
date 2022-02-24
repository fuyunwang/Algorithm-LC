package com.gopher.leetcode.order.or1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code1074
 * @Author fyw
 * @Date 2022/2/6 10:20
 * @Description: 元素和为目标值的子矩阵数量
 * 前缀和，横向前缀和+纵向前缀和，利用两数之和的思想优化S(r)-T=S(l-1)
 */
public class Code1074 {
    // 双重for循环固定行的每一个区间
    // 枚举每一个列方向的前缀和
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // 预处理列方向前缀和
        int m=matrix.length, n=matrix[0].length;
        int[][] s=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j]=s[i-1][j]+matrix[i-1][j-1];
            }
        }

        int res=0;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int sum=0;
                Map<Integer,Integer> map=new HashMap<>();
                map.put(0,1);// 个为0的子矩阵个数为1个
                // 枚举纵方向
                for (int k = 1; k <= n; k++) {
                    // 记录当前结果，之后存入缓存，后续判断有无缓存中的数据和当前和的差为target
                    sum+=s[j][k]-s[i-1][k];
                    res+=map.getOrDefault(sum-target,0);
                    map.put(sum,map.getOrDefault(sum,0)+1);

                }
            }
        }
        return res;
    }
}
