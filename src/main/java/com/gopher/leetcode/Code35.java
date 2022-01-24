package com.gopher.leetcode;

/**
 * @Title Code35
 * @Author fyw
 * @Date 2022/1/24 16:33
 * @Description:
 */
public class Code35 {
    public int searchInsert(int[] nums, int target) {
        if (target<nums[0]){
            return 0;
        }
        if (target>nums[nums.length-1]){
            return nums.length;
        }
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]<target){
                l=mid+1;
            }else if (nums[mid]>target){
                r=mid;
            }else{
                return mid;
            }
        }
        return r;
    }
}
