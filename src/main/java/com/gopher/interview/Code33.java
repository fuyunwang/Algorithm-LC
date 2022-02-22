package com.gopher.interview;

/**
 * @Title Code33
 * @Author fyw
 * @Date 2022-02-22 10:59
 * @Description 寻找峰值
 * LeetCode162
 */
public class Code33 {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]>nums[mid+1]) r=mid;
            else l=mid+1;
        }
        return r;
    }
}
