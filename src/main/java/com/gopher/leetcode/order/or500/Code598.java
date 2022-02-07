package com.gopher.leetcode.order.or500;

/**
 * @Title Code598
 * @Author fyw
 * @Date 2022/2/7 15:33
 * @Description:
 * 本质是求交集，记录矩阵的右下角点索引即可
 */
public class Code598 {
    public int maxCount(int m, int n, int[][] ops) {
        int x=m,y=n;
        for (int[] p:ops){
            x=Math.min(x,p[0]);
            y=Math.min(y,p[1]);
        }
        return x*y;
    }
}
