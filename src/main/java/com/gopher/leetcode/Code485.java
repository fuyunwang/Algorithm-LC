package com.gopher.leetcode;

/**
 * @Title Code485
 * @Author fyw
 * @Date 2022/1/30 19:40
 * @Description: 连续1的个数
 */
public class Code485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int max=0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                count+=1;
            }else{
                max=Math.max(max,count);
                count=0;
            }
        }
        return Math.max(max,count);
    }
}
