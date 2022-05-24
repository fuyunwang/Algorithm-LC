package com.fuyunwang.bilibili.order.hot100;

import java.util.Stack;

/**
 * @Title Code739
 * @Author fyw
 * @Date 2022/5/24 22:03
 * @Description:
 */
public class Code739 {
    /**
     * 单调栈的模板题目，
     * 1. 求数组中每一个元素左边第一个更小的数
     * 2. 求数组中每一个元素右边第一个更大的数
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()])
                stack.pop();
            if (!stack.isEmpty()){
                res[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return res;
    }
}
