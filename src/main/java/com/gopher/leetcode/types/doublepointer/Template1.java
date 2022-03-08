package com.gopher.leetcode.types.doublepointer;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-01 21:44
 * @Description
 */
public class Template1 {
    static class Code11{

    }
    static class Code922{
        // 奇偶排序数组
        public int[] sortArrayByParityII(int[] nums) {
            for (int i = 0,j=1; i < nums.length&&j<nums.length; i+=2,j+=2) {
                while (i<nums.length&&nums[i]%2==0) i+=2;
                while (j<nums.length&&nums[j]%2!=0) j+=2;
                if (j<nums.length){
                    swap(nums,i,j);
                }
            }
            return nums;
        }
        void swap(int[] arr,int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    static class Code1089{
        // 有点插排的思想
        public void duplicateZeros(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==0){
                    for (int j = arr.length-1; j >i ; j--) {
                        arr[j]=arr[j-1];
                    }
                    i++;
                }
            }
        }
    }
}
