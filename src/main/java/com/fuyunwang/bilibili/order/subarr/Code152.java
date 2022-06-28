package com.fuyunwang.bilibili.order.subarr;

import java.util.Arrays;

/**
 * @Title Code152
 * @Author fyw
 * @Date 2022-05-25 9:06
 * @Description 最大子数组积
 */
public class Code152 {
    /**
     * 考虑以第i个数为最右端点区间的最大子数组积与以第i-1个数为最右端点区间的最大子数组积的关系
     * f[i-1]记录可能的最小负数
     * g[i-1]记录可能的最大正数
     */
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int[] f=new int[nums.length+10];
        f[0]=1;
        int[] g=new int[nums.length+10];
        g[0]=1;
        for (int i = 1; i <= nums.length; i++) {
            int cur=nums[i-1];
            f[i]=Math.min(cur,Math.min(f[i-1]*cur,g[i-1]*cur));
            g[i]=Math.max(cur,Math.max(f[i-1]*cur,g[i-1]*cur));
            res=Math.max(res,g[i]);
        }
        return res;
    }
}
