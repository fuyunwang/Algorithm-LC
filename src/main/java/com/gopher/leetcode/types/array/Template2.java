package com.gopher.leetcode.types.array;

import java.util.TreeMap;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-03 16:01
 * @Description 差分数组
 * 差分数组实现了在区间重叠后，得到的res数组即根据端点值来查询重叠元素数量
 */
public class Template2 {
    /**
     * 题目抽象后，就是给定一个初始全 0 的数组，然后每次将区间 [i, j] 统一增加 k，问操作了若干次之后每个位置的值是多少。
     * 这类经典的问题可以采用区间标记的方式解决。将区间 [i, j] 统一增加 k，我们想象成在 i 位置增加 k，在 j + 1 的位置减少 k。
     * 对于每次增加都如此操作，最后每个位置的前缀和就是当前位置最终的值。
     */
    static class Code1109{
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] result=new int[n];// 注意result初始值全为0
            for (int i = 0; i < bookings.length; i++) {
                //首航班对应的索引加值，尾航班对应的索引的下一位减值，如果尾航班索引为最后一个则不需要减
                result[bookings[i][0]-1]+=bookings[i][2];
                if (bookings[i][1]<n){
                    result[bookings[i][1]]-=bookings[i][2];
                }
            }
            for (int i = 1; i < result.length; i++) {
                result[i]+=result[i-1];
            }
            return result;
        }
    }
    static class Code1854{
        public int maximumPopulation(int[][] logs) {
            int offset=1950;
            int[] temp=new int[101];
            for (int i = 0; i < logs.length; i++) {
                temp[logs[i][0]-offset]+=1;
                temp[logs[i][1]-offset]-=1;
            }
            for (int i = 1; i < temp.length; i++) {
                temp[i]+=temp[i-1];     // 到此 所有区间变化都累积到temp这一个数组里面
            }
            int max=0, res=logs[0][0];
            for (int i = 0; i < logs.length; i++) { // 到整合数组里面取找到最大值 和 当前索引匹配的位置
                if (max<=temp[logs[i][0]-offset]){
                    if(max==temp[logs[i][0]-offset]){
                        res=Math.min(logs[i][0],res);
                    }else{
                        res=logs[i][0];
                    }
                    max=temp[logs[i][0]-offset];
                }
            }
            return res;
        }
    }
    static class Code1094{
        public boolean carPooling(int[][] trips, int capacity) {
            int[] res=new int[1001];
            for (int i = 0; i < trips.length; i++) {
                res[trips[i][1]]+=trips[i][0];
                if (trips[i][2]<1000){
                    res[trips[i][2]]-=trips[i][0];
                }
            }
            for (int i = 1; i < res.length; i++) {
                res[i]+=res[i-1];
            }
            for (int i = 0; i < res.length; i++) {
                if (res[i]>capacity){
                    return false;
                }
            }
            return true;
        }
    }
    static class Code731{
        class MyCalendarTwo {
            TreeMap<Integer, Integer> map = new TreeMap<>(); // 按照key从小到大排序
            public MyCalendarTwo() {

            }

            public boolean book(int start, int end) {
                map.put(start, map.getOrDefault(start, 0) + 1);
                map.put(end, map.getOrDefault(end, 0) - 1);
                int sum = 0;
                for (int n : map.values()) {        // 类似差分，但并不是区间内每一个值都加数而是在最后结果中维护状态
                    sum += n;
                    if (sum >= 3) {
                        map.put(start, map.get(start) - 1);
                        map.put(end, map.get(end) + 1);
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
