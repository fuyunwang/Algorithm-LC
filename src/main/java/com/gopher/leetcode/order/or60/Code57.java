package com.gopher.leetcode.order.or60;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code57
 * @Author fyw
 * @Date 2022/2/2 16:34
 * @Description: 插入区间，分三个部分考虑，左边无交集部分，中间有交集需要合并部分以及右边无交集部分
 */
public class Code57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        int k=0;
        while (k < intervals.length && intervals[k][1] < newInterval[0]) list.add(intervals[k++]);

        if (k<intervals.length){
            newInterval[0] = Math.min(intervals[k][0],newInterval[0]);
            while (k<intervals.length&&intervals[k][0]<=newInterval[1]) newInterval[1]=Math.max(newInterval[1], intervals[k++][1]);
        }
        list.add(new int[]{newInterval[0],newInterval[1]}); // 注意交集情况的处理要放到if外

        while (k<intervals.length) list.add(intervals[k++]);
        int[][] res=new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0]=list.get(i)[0];
            res[i][1]=list.get(i)[1];
        }
        return res;
    }
}
