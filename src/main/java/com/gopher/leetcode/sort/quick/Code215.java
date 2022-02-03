package com.gopher.leetcode.sort.quick;

/**
 * @Title Code215
 * @Author fyw
 * @Date 2022/2/3 20:18
 * @Description: 基于快排实现查找数组中的第K大元素
 */
public class Code215 {
    public int findKthLargest(int[] nums, int k) {
        // 求得是第K大，位置是第k-1位置，排序从大到小排序
        return quickSort(nums,0,nums.length-1,k-1);
    }
    public int quickSort(int[] nums, int l, int r, int k){
        if (l>=r){
            return nums[l];
        }
        int i=l-1,j=r+1,x=nums[l];
        while (i<j){
            while (nums[++i]>x);
            while (nums[--j]<x);
            if (i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        if (k<=j) return quickSort(nums,l,j,k);
        // k比当前位置大从右边查找
        return quickSort(nums,j+1,r,k);
    }
}
