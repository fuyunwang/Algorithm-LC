package com.gopher.leetcode.order.or120;

/**
 * @Title Code198
 * @Author fyw
 * @Date 2022/2/8 21:20
 * @Description: 打家劫舍
 */
public class Code198 {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] f=new int[n+1]; // f记录当前第i选的时候最大值
        int[] g=new int[n+1]; // g记录当前第i不选的时候最大值
        for (int i = 1; i <= n; i++) {
            f[i]=g[i-1]+nums[i-1];          // 注意f中的索引1对应的是nums[0]，然而g和f的索引不需要纠结直接考虑递推
            g[i]=Math.max(f[i-1],g[i-1]);   // 第i个没选，第i-1个可选可不选
        }
        return Math.max(f[n],g[n]);
    }
}
