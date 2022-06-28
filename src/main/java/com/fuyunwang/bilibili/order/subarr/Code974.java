package com.fuyunwang.bilibili.order.subarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code974
 * @Author fyw
 * @Date 2022-05-25 9:08
 * @Description 和可被K整除的子数组
 * 求和能够被K整除的非空子数组的数目
 */
public class Code974 {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int[] sum=new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
        Map<Integer,Integer> map=new HashMap<>();   // 记录每一个前缀和对应的对K余数
        map.put(0,1);                               // 整个前缀如果满足题意也是可以的
        int res=0;
        for (int i = 1; i <= n; i++) {
            int cur=(sum[i]%k+k)%k;
            res+=map.getOrDefault(cur,0);
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        return res;
    }
}
