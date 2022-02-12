package com.gopher.leetcode.order.or60;

/**
 * @Title Code69
 * @Author fyw
 * @Date 2022/2/8 21:11
 * @Description: x的平方根 即找一个最大的y使得y的平方小于等于x
 * 高频题，注意边界
 */
public class Code69 {
    public int mySqrt(int x) {
        long left=0,right=x;
        while (left<right){
            long mid=left+1l+right>>1;
            if (mid<=x/mid) left=mid;
            else right=mid-1;
        }
        return (int) right;
    }
}
