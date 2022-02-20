package com.gopher.leetcode.order.or40;

/**
 * @Title Code34
 * @Author fyw
 * @Date 2022/2/2 16:56
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * 高频题目，即二分，左右边界的二分、
 * Code540二分
 * Code1894二分
 * Code34
 * Code35
 */
public class Code34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return new int[]{-1,-1};
        int[] res=new int[2];
        // 查找左侧边界
        int n=nums.length;
        int l=0,r=n-1;
        while(l<r){
            int mid=l+r>>1;
            if(nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(nums[l]==target){
            res[0]=l;
        }else{
            res[0]=-1;
        }
        // 查找右侧边界
        l=0;
        r=n-1;
        while(l<r){
            int mid=l+r+1>>1;
            if(nums[mid]<=target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        if(nums[l]==target){
            res[1]=l;
        }else{
            res[1]=-1;
        }
        return res;
    }
}
