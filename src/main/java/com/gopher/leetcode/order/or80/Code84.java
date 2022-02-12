package com.gopher.leetcode.order.or80;

import java.util.Stack;

/**
 * @Title Code84
 * @Author fyw
 * @Date 2022/2/9 13:33
 * @Description: 柱状图中的最大矩形
 * 单调栈，找到一个序列中左边第一个比他小的最近的数的下标
 * 本题需要求左边第一个比他小的数以及右边第一个比他小的数，扫描两遍即可
 *
 * 如何找到左边第一个比它小的柱子的位置？
 * 维护一个单调递增的栈，当枚举到当前柱子时，若栈顶元素的值比它大，则将栈顶元素pop出，直到栈顶元素的值小于等于它为止
 */
public class Code84 {
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
            res=Math.max(res,heights[i]*(right[i]-left[i]-1)); // 右边第一个小和左边第一个小之间的差值作为宽，heights[i]作为高
        }
        return res;
    }
}
