package com.gopher.leetcode.types.array;

import java.util.TreeMap;

/**
 * @Title Template6
 * @Author fyw
 * @Date 2022-03-08 14:45
 * @Description 区间问题
 */
public class Template6 {
    static class Code729{
        class MyCalendar{
            TreeMap<Integer/*开始数字*/, Integer/*结束数字*/> treeMap = new TreeMap();
            public MyCalendar() {}
            public boolean book(int start, int end) {
                Integer lowerGreatest = treeMap.floorKey(start);
                if (lowerGreatest != null && treeMap.get(lowerGreatest) > start) {
                    return false;
                }
                Integer greaterLowest = treeMap.ceilingKey(start);
                if (greaterLowest != null && greaterLowest < end) {
                    return false;
                }
                treeMap.put(start, end);
                return true;
            }
        }
    }
    static class Code699{

    }
}
