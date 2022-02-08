package com.gopher.leetcode.order.or200;

/**
 * @Title Code215
 * @Author fyw
 * @Date 2022/2/3 20:01
 * @Description: 数组中的第K个最大元素，快速排序
 */
public class Code215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k-1);// 第k大，索引位置是k-1，注意从大到小排序
    }

    public int quickSort(int[] nums,int l,int r,int k){
        if (l>=r)
            return nums[l];
        int i=l-1,j=r+1,x=nums[l];
        while (i<j){
            while (nums[++i]>x);
            while (nums[--j]<x);
            if (i<j)
                swap(nums,i,j);
        }
        if (k<=j) return quickSort(nums,l,j,k);
        else return quickSort(nums,j+1,r,k);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
