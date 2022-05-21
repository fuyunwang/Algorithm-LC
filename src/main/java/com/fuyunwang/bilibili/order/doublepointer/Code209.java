package com.fuyunwang.bilibili.order.doublepointer;

/**
 * @Title Code209
 * @Author fyw
 * @Date 2022-05-12 12:47
 * @Description
 */
public class Code209 {
    public int minSubArrayLen(int target, int[] nums) {// 子数组问题考虑560题目
        int sum=0;
        int res=Integer.MAX_VALUE;
        for (int i = 0,j=0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum-nums[j]>=target)
                sum-=nums[j++];
            if (sum>=target)
                res=Math.min(res,i-j+1);

        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
