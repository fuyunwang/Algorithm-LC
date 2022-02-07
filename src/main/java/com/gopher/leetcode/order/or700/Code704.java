package com.gopher.leetcode.order.or700;

/**
 * @Title Code704
 * @Author fyw
 * @Date 2022/2/1 10:45
 * @Description:
 */
public class Code704 {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+r>>1;
            if (nums[mid]>target){
                r=mid-1;
            }else if (nums[mid]<target){
                l=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
