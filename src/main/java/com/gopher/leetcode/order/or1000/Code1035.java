package com.gopher.leetcode.order.or1000;

import java.util.Arrays;

/**
 * @Title Code1035
 * @Author fyw
 * @Date 2022-02-26 15:44
 * @Description 不相交的线
 * 模板题，最长上升子序列模型中的友好城市题目，考虑二维偏序
 */
public class Code1035 {
//    class PII {
//        int x, y;
//        public PII(int x, int y) {this.x = x; this.y = y;}
//    }
//    public int maxUncrossedLines(int[] nums1, int[] nums2) {
//        int n=nums1.length;
//        int[] f=new int[n+10];
//        PII[] q=new PII[n+10];
//        for (int i = 1; i <= n; i++) {
//            q[i]=new PII(nums1[i],nums2[i]);
//        }
//        int res=0;
//        Arrays.sort(q, 1, n + 1, (o1, o2) -> o1.x - o2.x);
//        for (int i = 1; i <= n; i++)
//        {
//            f[i] = 1;
//            for (int j = 1; j < i; j++)
//                if (q[j].y < q[i].y) f[i] = Math.max(f[i], f[j] + 1);
//            res = Math.max(res, f[i]);
//        }
//        return res;
//    }
}
