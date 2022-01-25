package com.gopher.leetcode;

/**
 * @Title Code1109
 * @Author fyw
 * @Date 2022/1/25 9:18
 * @Description: 经典差分
 */
public class Code1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result=new int[n];
        for (int i = 0; i < bookings.length; i++) {
            result[bookings[i][0]-1]+=bookings[i][2];
            if (bookings[i][1]<n){
                result[bookings[i][1]]-=bookings[i][2];
            }
        }
        for (int i = 1; i < n; i++) {
            result[i]+=result[i-1];
        }
        return result;
    }
}
