package com.fuyunwang.bilibili.order.subarr;

/**
 * @Title Code209
 * @Author fyw
 * @Date 2022-05-25 9:06
 * @Description 满足其和 ≥ target 的长度最小的子数组
 * 双指针、前缀和
 */
public class Code209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int sum=0;
        for (int i = 0,j=0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum>=target){
                res=Math.min(i-j+1,res);
                sum-=nums[j++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
