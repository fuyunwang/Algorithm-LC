package com.fuyunwang.bilibili.order.subarr;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Title Code523
 * @Author fyw
 * @Date 2022-05-25 9:06
 * @Description 连续的子数组和
 * 判断是不是含有长度大于等于2且和为k的倍数的子数组
 */
public class Code523 {
    /**
     * Si-Sj
     * 考虑长度的问题，前缀和+哈希
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] sum=new int[n+10];
        for (int i = 1; i <= n; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
        HashMap<Integer,Integer> map=new HashMap<>();   // key为每个前缀和对应的k的余数，key为每个索引；和为k的倍数的子数组要求两个前缀和模k同余
        for (int i = 2; i <= n; i++) {      // 长度大于等于2
            // 注意数据元素全为正数
            map.put(sum[i-2]%k,i);          // 虽然只是计算i-2，但由于是递推过程，遍历当前i时，与i形成的大于等于2的子数组都存入map了
            if (map.containsKey(sum[i]%k)){
                return true;
            }
        }
        return false;
    }
}
