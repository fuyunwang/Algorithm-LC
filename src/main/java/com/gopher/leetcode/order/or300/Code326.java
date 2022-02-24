package com.gopher.leetcode.order.or300;

/**
 * @Title Code326
 * @Author fyw
 * @Date 2022/2/9 13:55
 * @Description: 3的幂
 */
public class Code326 {
    // 3的幂最大是3的19次方，故n<=三的幂最大值并且能整除
    public boolean isPowerOfThree(int n) {
        return n>0 && Math.pow(3,19)%n==0;
    }
}
