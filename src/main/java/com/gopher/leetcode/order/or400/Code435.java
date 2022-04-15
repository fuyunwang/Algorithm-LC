package com.gopher.leetcode.order.or400;

import java.util.Arrays;

/**
 * @Title Code435
 * @Author fyw
 * @Date 2022/2/9 13:39
 * @Description: 无重叠区间
 * 贪心算法，按照起点排序：选择结尾最短的，后面才可能连接更多的区间（如果两个区间有重叠，应该保留结尾小的）
 * 把问题转化为最多能保留多少个区间，使他们互不重复，则按照终点排序，每个区间的结尾很重要，结尾越小，则后面越有可能容纳更多的区间。
 */
public class Code435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals==null||intervals.length<1||intervals[0].length<1)
            return 0;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int end=intervals[0][1];
        int res=1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>=end){
                res++;
                end=intervals[i][1];
            }
        }
        return intervals.length-res;
    }
}
