package com.gopher.leetcode.order.or500;

/**
 * @Title Code540
 * @Author fyw
 * @Date 2022/2/9 14:48
 * @Description: 有序数组中的单一元素
 */
public class Code540 {

    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid=(l+r)/2;
            // 偶数 mid ^ 1 是 mid + 1
            // 奇数 mid ^ 1 是 mid - 1
            if (nums[mid]!=nums[mid^1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }
}
