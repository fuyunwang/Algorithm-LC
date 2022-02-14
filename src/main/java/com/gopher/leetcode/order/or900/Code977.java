package com.gopher.leetcode.order.or900;

/**
 * @Title Code977
 * @Author fyw
 * @Date 2022/2/8 22:08
 * @Description: 有序数组的平方
 * 给定有序数组，对每一个数字进行平方然后返回有序结果数组
 */
public class Code977 {

    // 问题在于数组中包含负数，所以平方后可能未有序
    // 以负数和正数的分界线，二路归并
    // 注意有序数组可以利用双指针
    public int[] sortedSquares(int[] nums) {
        int[] res=new int[nums.length];
        for (int i = 0,j=nums.length-1,k=nums.length-1; i <= j; ) {
            if (nums[i]*nums[i]>nums[j]*nums[j]){
                res[k--]=nums[i]*nums[i];
                i++;
            }else{
                res[k--]=nums[j]*nums[j];
                j--;
            }
        }
        return res;
    }
}
