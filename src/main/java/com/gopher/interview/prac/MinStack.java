package com.gopher.interview.prac;

import java.util.Stack;

/**
 * @Title MinStack
 * @Author fyw
 * @Date 2022/2/8 17:18
 * @Description: 栈实现获得最小值
 * 重复压入法
 */
public class MinStack {
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            int t = minStack.peek();
            if (t < x){
                minStack.push(t);
            }else {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
