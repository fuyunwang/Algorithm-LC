package com.gopher.ending.math;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022/3/13 23:45
 * @Description:
 */
public class Template1 {
    static class Code875{
        //二分
        public int minEatingSpeed(int[] piles, int h) {
            int l = 1, r = (int)1e9;
            while (l < r){
                int mid = (l + r) >> 1;
                if (get(piles, mid) <= h) r = mid;
                else l = mid + 1;
            }
            return l;
        }
        int get(int[] piles, int mid){
            int res = 0;
            for (int x:piles){
                res += (x + mid - 1)/mid;
            }
            return res;
        }
    }
}
