package com.gopher.interview;

import java.util.Stack;

/**
 * @Title Code28
 * @Author fyw
 * @Date 2022-02-22 10:57
 * @Description 直方图中最大的矩形
 * LeetCode84 LeetCode85
 */
public class Code28 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[heights.length+10];
        int[] right=new int[heights.length+10];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]) stack.pop();
            if (stack.isEmpty())
                left[i]=-1;
            else
                left[i]=stack.peek();// 记录
            stack.push(i);
        }
        stack=new Stack<>();
        for (int i = heights.length-1; i >= 0; i--) {
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]) stack.pop();
            if (stack.isEmpty())
                right[i]= heights.length;
            else
                right[i]=stack.peek();
            stack.push(i);
        }
        int res=Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            res=Math.max(res,heights[i]*(right[i]-left[i]-1));
        }
        return res;
    }
}
