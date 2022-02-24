package com.gopher.leetcode.order.or300;

/**
 * @Title Code367
 * @Author fyw
 * @Date 2022/2/9 14:46
 * @Description: 有效的完全平方数
 */
public class Code367 {
    public boolean isPerfectSquare(int num) {
        int l=1,r=num;
        while (l<r){
            int mid=l+r+1>>1;
            if (mid<=num/mid) {
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return l*l==num;
    }
}
