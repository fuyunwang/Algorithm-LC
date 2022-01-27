package com.gopher.leetcode;

import java.util.HashSet;

/**
 * @Title Code41
 * @Author fyw
 * @Date 2022/1/27 13:47
 * @Description:
 */
public class Code41 {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        if (n==0)
            return 1;
        for (int i = 0; i < n; i++) {
            if (i!=Integer.MIN_VALUE)
                nums[i]--;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>=0&&nums[i]<n&&nums[i]!=i&&nums[i]!=nums[nums[i]]){
                swap(nums,nums[i],i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i)
                return i+1;
        }
        return n+1;
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public int firstMissingPositive1(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res=1;
        while (set.contains(res)) res++;
        return res;
    }
}
