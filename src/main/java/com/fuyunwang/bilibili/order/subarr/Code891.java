package com.fuyunwang.bilibili.order.subarr;

import java.util.Arrays;

/**
 * @Title Code891
 * @Author fyw
 * @Date 2022-05-25 9:15
 * @Description 子序列宽度之和，宽度为一个子序列中  最大值-最小值
 * 求每个元素作为最大值和最小值时的贡献，对原数组排序，
 *      选择当前元素左边时当前元素作为最大值，选择当前元素右边时当前元素作为最小值
 */
public class Code891 {
    /**
     * 子集等价于子序列
     */
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int MOD= (int) (1e9+7);
        // 预处理所有2的次方
        long[] P=new long[n];
        P[0]=1;
        for (int i = 1; i < n; i++) {
            P[i]=P[i-1]*2%MOD;
        }
        long res=0;
        for (int i = 0; i < n; i++) {
            res=(res+(P[i]-P[n-i-1])*nums[i])%MOD;
        }
        return (int) res;
    }
}