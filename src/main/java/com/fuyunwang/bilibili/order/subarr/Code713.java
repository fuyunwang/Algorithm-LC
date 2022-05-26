package com.fuyunwang.bilibili.order.subarr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code713
 * @Author fyw
 * @Date 2022-05-25 9:08
 * @Description 乘积小于k的子数组
 * 数组内所有元素乘积严格小于k的子数组的个数
 * Code560也是关于数目的求解问题
 */
public class Code713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int[] sum=new int[n+10];
        sum[0]=1;
        for (int i = 1; i <= n; i++) {
            sum[i]=sum[i-1]*nums[i-1];
        }
        int res=1;
        
    }
}
