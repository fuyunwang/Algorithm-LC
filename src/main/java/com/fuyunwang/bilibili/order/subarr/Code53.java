package com.fuyunwang.bilibili.order.subarr;

/**
 * @Title Code53
 * @Author fyw
 * @Date 2022-05-25 9:06
 * @Description 最大子数组和、所有子数组中和最大的结果
 * dp
 */
public class Code53 {
    /**
     * f[i]表示所有以nums[i]结尾的区间中，最大值是多少
     * f[i]=Math.max(nums[i],f[i-1]+nums[i])
     */
    public int maxSubArray(int[] nums) {
        int[] f=new int[nums.length+10];
        int res=nums[0];
        for (int i = 1; i <= nums.length; i++) {
            f[i]=Math.max(f[i-1]+nums[i-1],nums[i-1]);
            res=Math.max(f[i],res);
        }
        return res;
    }

}
