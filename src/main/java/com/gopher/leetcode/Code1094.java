package com.gopher.leetcode;

/**
 * @Title Code1094
 * @Author fyw
 * @Date 2022/1/28 12:22
 * @Description: 拼车，差分数组
 */
public class Code1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res=new int[1001];
        for (int i = 0; i < trips.length; i++) {
            res[trips[i][1]]+=trips[i][0];
            res[trips[i][2]]-=trips[i][0];
        }
        int sum=0;
        for (int i = 0; i < res.length; i++) {
            sum+=res[i];
            if (sum>capacity)
                return false;
        }
        return true;
    }
}
