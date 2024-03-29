package com.gopher.leetcode.order.or900;

/**
 * @Title Code922
 * @Author fyw
 * @Date 2022/1/29 19:57
 * @Description:
 * 两个指针分别枚举奇数位置和偶数位置，找到第一个不满足条件的数字然后交换
 */
public class Code922 {
    public int[] sortArrayByParityII(int[] nums) {
        // 外部循环配合内部循环保证遍历每一个奇数和偶数
        for (int i = 0,j=1; i<nums.length; i+=2,j+=2) {
            while (i<nums.length&&nums[i]%2==0) i+=2;
            while (j<nums.length&&nums[j]%2!=0) j+=2;
            if (i<nums.length) swap(nums,i,j);
        }
        return nums;
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
