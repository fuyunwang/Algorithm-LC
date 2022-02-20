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
    public int search(int[] nums, int target){
        if (nums==null||nums.length==0)
            return -1;
        // 思路就是首先枚举中间边界，旋转点。考虑的二段性就是是否比nums[0]大
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+r+1>>1;
            if (nums[mid]>=nums[0]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        // 此时l=r=旋转点
        if (target==nums[l]) return l;
        if (target<nums[0]){
            l=l+1;
            r=nums.length-1;
        }else{
            l=0;
        }

        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if (nums[r]==target){
            return l;
        }
        return -1;
    }
    public int search1(int[] nums, int target) {
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
