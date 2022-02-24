package com.gopher.leetcode.order.or200;

/**
 * @Title Code223
 * @Author fyw
 * @Date 2022/2/9 12:40
 * @Description: 矩形面积
 */
public class Code223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        long x=Math.max(0,Math.min(ax2,bx2)-Math.max(ax1,bx1));
        long y=Math.max(0,Math.min(ay2,by2)-Math.max(ay1,by1));
        return (int) ((ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - x*y);
    }
}
