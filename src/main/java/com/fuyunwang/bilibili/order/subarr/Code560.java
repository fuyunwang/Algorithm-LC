package com.fuyunwang.bilibili.order.subarr;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Title Code560
 * @Author fyw
 * @Date 2022-05-25 9:07
 * @Description 和为k的子数组的个数
 */
public class Code560 {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] sum=new int[n+10];
        for (int i = 1; i <= n; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);       // 前缀和0出现过1次
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(sum[i]-k)){
                res+=map.get(sum[i]-k);
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return res;
    }
}
