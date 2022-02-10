package com.gopher.leetcode.order.or40;

/**
 * @Title Code33
 * @Author fyw
 * @Date 2022/2/8 21:16
 * @Description: 搜索旋转排序数组
 * 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，
 * 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
 */
public class Code33 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int left=0,right=len-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target)
                return mid;
            if (nums[mid]<nums[right]){
                //右半段有序
                if (nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if (nums[left]<=target&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }

            }
        }
        return -1;
    }
}
