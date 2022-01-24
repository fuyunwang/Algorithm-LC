package com.gopher.leetcode;

/**
 * @Title Code31
 * @Author fyw
 * @Date 2022/1/24 12:39
 * @Description:
 */
public class Code31 {
    public void nextPermutation(int[] nums) {
        int k=nums.length-1;
        //从后向前找第一个升序的位置
        while (k > 0 && nums[k - 1] >= nums[k]) k--;
        if (k<=0){
            reverse(nums,0,nums.length-1);
        }else{
            int t=k;
            // 从当前升序的第一个位置往后找
            while (t<nums.length&&nums[t]>nums[k-1]) t++;
            swap(nums,k-1,t-1);
            reverse(nums,k,nums.length-1);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void reverse(int[] arr,int l,int r){
        while (l<r){
            swap(arr,l++,r--);
        }
    }
}
