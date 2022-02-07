package com.gopher.leetcode.order.or400;

import java.util.Map;

/**
 * @Title Code458
 * @Author fyw
 * @Date 2022/1/30 13:43
 * @Description: 可怜的小猪 脑筋急转弯
 */
public class Code458 {
    // 找规律 一头猪在minutesToTest中里可以检测 minutesToTest/minutesToDie+1数量的桶
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs=0;
        while (Math.pow((minutesToTest/minutesToDie)+1,pigs)<buckets)
            pigs++;
        return pigs;
    }
}
