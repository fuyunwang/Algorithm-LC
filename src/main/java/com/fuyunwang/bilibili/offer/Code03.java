package com.fuyunwang.bilibili.offer;

/**
 * @Title Offer03
 * @Author fyw
 * @Date 2022-05-25 16:25
 * @Description
 */
public class Code03 {
    static class Method1{
        // 时间复杂度 O(N)，空间复杂度O(1)
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]<0||nums[i]>=nums.length)
                    return -1;
                while (i!=nums[i]&&nums[nums[i]]!=nums[i]){ // i上的位置和 nums[nums[i]]上的数都不正确
                    swap(nums,i,nums[i]);
                }
                if (i!=nums[i]&&nums[i]==nums[nums[i]])
                    return nums[i];
            }
            return -1;
        }
        private void swap(int[] arr,int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    static class Method2{
        public int findRepeatNumber(int[] nums) {

        }

    }
}
