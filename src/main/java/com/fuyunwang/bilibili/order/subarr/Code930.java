package com.fuyunwang.bilibili.order.subarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code930
 * @Author fyw
 * @Date 2022-05-25 9:08
 * @Description 和相同的二元子数组
 * 求子数组和能凑出goal的数目
 * 930.325.560.523.974
 */
public class Code930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int[] sum=new int[n+10];
        for (int i = 1; i <=n ; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }

        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);   // 前缀和为0的子数组出现过一次
        for (int i = 1; i <= n; i++) {
            res+=map.getOrDefault(sum[i]-goal,0);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return res;
    }
}
