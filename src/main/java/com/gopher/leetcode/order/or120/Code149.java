package com.gopher.leetcode.order.or120;

import java.util.HashMap;

/**
 * @Title Code149
 * @Author fyw
 * @Date 2022/2/9 13:56
 * @Description: 直线上最多的点数
 * 给定n个点，判断有多少个点在一条直线上
 * 1、用哈希表记录经过固定点i的斜率的个数，即 斜率 -> 个数
 * 2、枚举其他所有点j，通过gcd算法计算出i点和j点的斜率，用a + "/" + b表示，在哈希表对于的斜率中+1，同时记录与i点重合的点的个数ss，以及i点垂直线上的点的个数vs
 * 3、枚举哈希表中的所有斜率，计算出对应个数val + ss的最大值，更新ans
 */
public class Code149 {
    int gcd(int a,int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public int maxPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        for(int i = 0;i < n;i ++) {
            HashMap<String, Integer> map = new HashMap<>(); // key为i的斜率，i的个数
            int ss = 0, vs = 0;//ss表示同一个点，vs表示垂直上的点
            for(int j = i;j < n;j ++) {
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    ss ++;
                }
                else if(points[i][0] == points[j][0]) vs ++;
                else {
                    int a = points[i][1] - points[j][1];
                    int b = points[i][0] - points[j][0];
                    int c = gcd(a, b);
                    a /= c;
                    b /= c;
                    String t = a + "/" + b;
                    map.put(t, map.getOrDefault(t, 0) + 1);
                }
            }

            int t = vs;
            for(Integer val : map.values()) {
                t = Math.max(t, val);
            }

            res = Math.max(res, t + ss);
        }
        return res;
    }
}
