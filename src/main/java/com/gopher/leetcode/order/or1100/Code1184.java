package com.gopher.leetcode.order.or1100;

/**
 * @Title Code1184
 * @Author fyw
 * @Date 2022/11/17 21:50
 * @Description
 */
public class Code1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start>destination){
            int temp=start;
            start=destination;
            destination=temp;
        }
        int sum=0;
        for (int i = 0; i < distance.length; i++) {
            sum+=distance[i];
        }
        int dis=0;
        for (int i = start; i < destination; i++) {
            dis+=distance[i];
        }
        return Math.min(dis,sum-dis);
    }
}
