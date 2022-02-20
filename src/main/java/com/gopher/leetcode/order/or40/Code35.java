package com.gopher.leetcode.order.or40;

/**
 * @Title Code35
 * @Author fyw
 * @Date 2022/1/24 16:33
 * @Description:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 即查找数组的左侧边界
 */
public class Code35 {

    public int searchInsert(int[] nums, int target){
        int l=0,r=nums.length;  // 定义答案区间，答案区间自始至终要包含答案
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public int searchInset1(int[] nums, int target) {
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
