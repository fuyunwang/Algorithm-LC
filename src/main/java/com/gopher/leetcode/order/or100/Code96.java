package com.gopher.leetcode.order.or100;

/**
 * @Title Code96
 * @Author fyw
 * @Date 2022/2/1 16:59
 * @Description:
 */
public class Code96 {
    public int numTrees(int n) {
        int[] f=new int[n+1];
        f[0]=1;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] += f[j-1]*f[i-j]; // j-1 和 i-(j+1)+1 表示以j为中心时左右两侧元素作为左右子树的情况
            }
        }
        return f[n];
    }
}
