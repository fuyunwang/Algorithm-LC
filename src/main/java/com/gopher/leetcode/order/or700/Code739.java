package com.gopher.leetcode.order.or700;

import java.util.Stack;

/**
 * @Title Code739
 * @Author fyw
 * @Date 2022/2/8 21:15
 * @Description: 每日温度，维护递增单调栈
 */
public class Code739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int temp=stack.pop();
                res[temp]=i-temp;
            }
            stack.push(i);
        }
        return res;
    }
}
