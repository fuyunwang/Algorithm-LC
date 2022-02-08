package com.gopher.leetcode.order.or120;

/**
 * @Title Code189
 * @Author fyw
 * @Date 2022/1/29 18:45
 * @Description: 轮转数组类似186题
 */
public class Code189 {
    public void rotate(int[] nums, int k) {
        // 翻转三次
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    public void reverse(int[] nums, int start, int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
