package com.gopher.ending.greed;

import java.util.*;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-14 10:29
 * @Description 区间贪心
 */
public class Template2 {
    static class Code646{
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
            int res = 1;
            int max = pairs[0][1];
            for (int i = 1; i < pairs.length; i++){
                if (pairs[i][0] > max){
                    res++;
                    max = pairs[i][1];
                }
            }
            return res;
        }
    }
}
