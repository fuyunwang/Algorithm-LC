package com.gopher.leetcode.order.or1100;

import java.util.Arrays;

/**
 * @Title Code1326
 * @Author fyw
 * @Date 2022/11/14 21:09
 * @Description 灌溉花园的最少水龙头数目
 * 区间覆盖，要求给定最少数量的区间将大区间覆盖，不断的选择左端点能能够接轨上一个区间右端点的右端点的最大值的区间
 */
public class Code1326 {
    public int minTaps(int n, int[] ranges) {
        int[][] q=new int[ranges.length][2];
        for (int i = 0; i < ranges.length; i++) {
            q[i]=new int[]{i-ranges[i],i+ranges[i]};
        }
        Arrays.sort(q,(a,b)->a[0]-b[0]);
        int res=0; // 记录区间数量
        int r=0;   // 记录初始右边界
        for (int i = 0; i < q.length; i++) {
            int mr=-1;
            int j=i;
            while (j<q.length&&r>=q[j][0])
                mr=Math.max(mr,q[j++][1]);
            if (mr==-1)
                return -1;
            res++;
            if (mr>=n)
                return res;
            r=mr;
            i=j-1;
        }
        return -1;
    }
}
