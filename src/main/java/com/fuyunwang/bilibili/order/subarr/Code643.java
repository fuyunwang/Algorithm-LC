package com.fuyunwang.bilibili.order.subarr;

/**
 * @Title Code643
 * @Author fyw
 * @Date 2022-05-25 9:07
 * @Description 子数组的最大平均数
 * 与209题是一道题目
 */
public class Code643 {
    public double findMaxAverage(int[] nums, int k) {
        int res=Integer.MIN_VALUE;
        for (int i = 0,j=0,sum=0,count=0; i < nums.length ; i++) {
            sum+=nums[i];
            count++;
            while (count>k){
                sum-=nums[j++];
                count--;
            }
            if (count==k){
                res=Math.max(res,sum);
            }
        }
        return res*1.0/k;
    }
}
