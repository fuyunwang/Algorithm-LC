package com.fuyunwang.bilibili.order.hot100;

/**
 * @Title Code198
 * @Author fyw
 * @Date 2022/5/22 21:38
 * @Description: 状态机DP
 */
public class Code198 {
    public int rob(int[] nums) {
        /**
         * f[i]必选i
         * g[i]必不选i
         *
         * f[i]=g[i-1]+wi
         * g[i]=Math.max(f[i-1],g[i-1])
         */
        int n=nums.length;
        int[] f=new int[n+10];
        int[] g=new int[n+10];
        for (int i = 1; i <= n; i++) {
            f[i]=g[i-1]+nums[i-1];// 必选i则i-1必不选
            g[i]=Math.max(f[i-1],g[i-1]);// 必选i-1和必不选i-1
        }
        return Math.max(f[n],g[n]);
    }
}
