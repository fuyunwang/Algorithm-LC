package com.gopher.leetcode.order.or900;

import java.util.HashMap;

/**
 * @Title Code974
 * @Author fyw
 * @Date 2022/2/9 14:49
 * @Description: 和可被 K 整除的子数组
 * 和与子数组确定用前缀和，
 * 子数组问题一般枚举右端点。
 *
 * 题目要求(si-sj)能够被k整除，则需要si与si是同余
 */
public class Code974 {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int[] sum=new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
        // 对前缀和的每一个元素进行枚举，记录余数并累计同余个数
        HashMap<Integer,Integer> count=new HashMap<>();//对于每一个余数记录次数
        count.put(0,1);// 初始如果为0那么算是一种情况
        int res=0;
        for (int i = 1; i <= n; i++) {
            int temp = (sum[i]%k+k)%k;  // 求满足负数情况下的余数
            res+=count.getOrDefault(temp,0);       // 累计可能的余数出现的次数
            count.put(temp,count.getOrDefault(temp,0)+1);
        }
        return res;
    }
}
