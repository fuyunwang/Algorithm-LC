package com.gopher.leetcode.order.or300;

/**
 * @Title Code338
 * @Author fyw
 * @Date 2022/2/9 14:42
 * @Description: 比特位计数，求0-n中每个数的二进制表示中1的个数
 * 递推求解
 */
public class Code338 {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        res[0]=0;
        for (int i = 1; i <= n; i++) {
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }
}
