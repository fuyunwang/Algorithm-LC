package com.gopher.ending.greed;

import java.util.*;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-14 10:29
 * @Description 区间贪心
 */
public class Template2 {
    static class Code406{
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (o1,o2) -> {
                if(o1[0] == o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            });
            List<int[]> list = new ArrayList<>();
            for(int[] p: people){
                list.add(p[1],p);
            }
            return list.toArray(new int[0][0]);
        }
    }
    static class Code632{
        // 最小区间、多路归并
    }
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
