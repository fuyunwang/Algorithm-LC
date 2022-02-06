package com.gopher.leetcode.order.or60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title Code56
 * @Author fyw
 * @Date 2022/1/31 20:54
 * @Description:
 */
public class Code56 {
    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length==0){
            return new int[0][0];
        }
        int n=intervals.length;
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        int start=intervals[0][0], end=intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0]>end){
                ans.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }else{
                end=Math.max(end,intervals[i][1]);
            }
        }
        ans.add(new int[]{start,end});
        int[][] res=new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0]=ans.get(i)[0];
            res[i][1]=ans.get(i)[1];
        }
        return res;
    }
}
