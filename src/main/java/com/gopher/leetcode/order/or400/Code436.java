package com.gopher.leetcode.order.or400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code436
 * @Author fyw
 * @Date 2022/4/15 21:20
 * @Description:
 */
public class Code436 {
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0],i);
        }
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for (int i = 0; i < n; i++) {
            int l=0,r=n-1;
            while(l<r){
                int mid=l+r>>1;
                if(intervals[mid][0]>=intervals[i][1]) r=mid;
                else
                    l=mid+1;
            }
            if (intervals[l][0]>=intervals[i][1])
                res[map.get(intervals[i][0])]=map.get(intervals[l][0]);
        }
        return res;
    }
}
