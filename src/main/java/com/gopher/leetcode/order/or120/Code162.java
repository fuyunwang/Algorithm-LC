package com.gopher.leetcode.order.or120;

/**
 * @Title Code162
 * @Author fyw
 * @Date 2022/1/30 15:12
 * @Description: 寻找峰值，类似找到下一个插入的位置，类似山脉数组取索引
 */
public class Code162 {
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=l+r>>1;
            if (nums[mid]>nums[mid+1]) r=mid;
            else l=mid+1;
        }
        return r;
    }
}
