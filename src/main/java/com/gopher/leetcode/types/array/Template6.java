package com.gopher.leetcode.types.array;

import java.util.TreeMap;

/**
 * @Title Template6
 * @Author fyw
 * @Date 2022-03-08 14:45
 * @Description 区间问题
 */
public class Template6 {
    static class Code56 {
        // 区间合并
    }
    static class Code1010{
        // 类似K倍区间

    }
    static class Code729 {
        class MyCalendar {
            TreeMap<Integer/*开始数字*/, Integer/*结束数字*/> treeMap = new TreeMap();

            public MyCalendar() {
            }

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

    static class Code699 {

    }

    static class Code836 {
        // 矩形重叠

        /**
         * 矩形如果不重叠，从x轴和y轴上看两个矩形就变成了两条线段，这两条线段肯定是不相交的，
         * 也就是说左边的矩形的最右边小于右边矩形的最左边，也就是rec1[2] < rec2[0] || rec2[2] < rec1[0]；
         * y轴同理，下面的矩形的最上边小于上面矩形的最下边，也就是rec1[3] < rec2[1] || rec2[3] < rec1[1]。
         */
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            if (rec1[0] >= rec2[2] || rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]) {
                return false;
            }
            return true;
        }
    }
}