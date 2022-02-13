package com.gopher.leetcode.order.or400;

/**
 * @Title Code495
 * @Author fyw
 * @Date 2022/2/9 13:52
 * @Description: 提莫攻击
 * 有点类似区间合并
 */
public class Code495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res=0;
        for (int i = 1; i < timeSeries.length; i++) {
            int time=timeSeries[i];
            int pre=timeSeries[i-1];
            if (time>=pre+duration){
                res+=duration;
            }else{
                res+=(time-pre);
            }
        }
        res+=duration;      // 注意要加上最后一次的持续时间
        return res;
    }
}
