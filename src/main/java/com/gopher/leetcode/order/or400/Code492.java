package com.gopher.leetcode.order.or400;

/**
 * @Title Code492
 * @Author fyw
 * @Date 2022/2/9 14:37
 * @Description:
 */
public class Code492 {
    public int[] constructRectangle(int area) {
        int W = (int)Math.sqrt(area);
        while(area%W !=0) W--;
        return new int[]{area/W,W};
    }
}
