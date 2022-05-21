package com.fuyunwang.bilibili.order.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code56
 * @Author fyw
 * @Date 2022/5/21 17:03
 * @Description: 区间问题
 */
public class Code56_57 {
    static class Code56{
        public int[][] merge(int[][] intervals) {
            if (intervals==null||intervals.length==0||intervals[0].length==0)
                return new int[0][0];
            Arrays.sort(intervals,(a,b)->a[0]-b[0]);
            List<int[]> list=new ArrayList<>();
            int start=intervals[0][0];
            int end=intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0]>end){
                    list.add(new int[]{start,end});
                    start=intervals[i][0];
                    end=intervals[i][1];
                }else{
                    end=Math.max(end,intervals[i][1]);
                }
            }
            list.add(new int[]{start,end});
            int[][] res=new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0]=list.get(i)[0];
                res[i][1]=list.get(i)[1];
            }
            return res;
        }
    }
    static class Code57{
        // 分成三部分求解
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list=new ArrayList<>();
            int k=0;
            while (k<intervals.length&&intervals[k][1]<newInterval[0])
                list.add(intervals[k++]);
            if (k<intervals.length){
                newInterval[0]=Math.min(newInterval[0],intervals[k][0]);
                while (k<intervals.length&&intervals[k][0]<=newInterval[1]){
                    newInterval[1]=Math.max(newInterval[1],intervals[k++][1]);
                }
            }
            list.add(newInterval);
            while (k<intervals.length){
                list.add(intervals[k++]);
            }
            int[][] res=new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i][0]=list.get(i)[0];
                res[i][1]=list.get(i)[1];
            }
            return res;
        }
    }
}
