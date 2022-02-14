package com.gopher.leetcode.order.or40;

/**
 * @Title Code34
 * @Author fyw
 * @Date 2022/2/2 16:56
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * 高频题目，即二分，左右边界的二分、
 * Code540二分
 */
public class Code34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        res[0]=search(nums,target,true);
        res[1]=search(nums,target,false);
        return res;
    }
    int search(int[] nums,int target,boolean isLeft){
        int left=0,right=nums.length-1;
        int res=-1;
        while (left<=right){            // 只有左闭右开时不取等号其他的都取
            int mid=(left+right)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }else{
                res=mid;
                if (isLeft){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return res;
    }
}
