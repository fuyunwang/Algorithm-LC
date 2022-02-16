package com.gopher.leetcode.order.or1000;

/**
 * @Title Code1004
 * @Author fyw
 * @Date 2022/2/9 14:06
 * @Description: 最大连续1的个数 III
 * 逆向思维，考虑最长的子区间最多包含K个0
 * 双指针维护的滑动窗口使得窗口内最多含有K个0
 */
public class Code1004 {
    public int longestOnes(int[] nums, int k) {
        int res=0;
        int count=0;
        for (int i = 0,j=0; i < nums.length; i++) {
            if (nums[i]==0)
                count++;
            while (count>k){
                if (nums[j]==0){
                    count--;
                }
                j++;
            }
            res=Math.max(res,i-j+1);
        }
        return res;
    }
}
