package com.gopher.leetcode.types.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    static class Code1052{
        // 爱生气的书店老板
    }

    static class Code2100{
        //  适合打劫银行的日子
        /**
         * 根据其中的两个要求：
         *  第 i 天前连续 time 天警卫数目都是非递增的、第 i 天后连续 time 天警卫数目都是非递减的。
         * 1. 说明合理的结果范围区间的起始索引是time，终止索引n-time。其中time可以取到,n-time取不到
         * 2. 枚举以上区间，然后对于区间的每一个值枚举其左侧time范围和右侧time范围，保证左侧time不严格升序，右侧time不严格降序
         *
         * 本题是山脉数组的逆向，山谷数组
         */
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            int n=security.length;
            int[] right=new int[n+1];   // 始终记录数组中当前索引下左侧小于等于当前数的个数
            int[] left=new int[n+1];    // 始终记录数组中当前索引下右侧大于等于当前数的个数
            for (int i = 1,j=0,k=0; i < security.length; i++) {
                if (security[i]<security[i-1]){
                    j++;
                }else if (security[i]>security[i-1]){
                    k++;
                }else{
                    j++;
                    k++;
                }
                right[i]=k;
                left[i]=j;
            }
            List<Integer> res=new ArrayList<>();
            for (int i = time; i < n-time; i++) {
                if (left[i]-left[i-time]==time&&right[i+time]-right[i]==time){
                    res.add(i);
                }
            }
            return res;
        }
    }

    static class Code2017{

    }
    static class Code845{

    }
}
