package com.gopher.leetcode.order.or100;

/**
 * @Title Code162
 * @Author fyw
 * @Date 2022/2/8 21:11
 * @Description: 寻找峰值
 */
public class Code162 {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]>nums[mid+1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }
}
