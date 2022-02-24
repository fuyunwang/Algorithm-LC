package com.gopher.leetcode.order.or200;

import java.util.Stack;

/**
 * @Title Code232
 * @Author fyw
 * @Date 2022/2/9 14:44
 * @Description: 用栈实现队列
 */
public class Code232 {
    class MyQueue {
        Stack<Integer> a = new Stack<Integer>();
        Stack<Integer> b = new Stack<Integer>();
        /** Initialize your data structure here. */
        public MyQueue() {
            a.clear();
            b.clear();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            a.add(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int n = a.size();
            for(int i = 0;i < n - 1;i ++) b.add(a.pop());
            int t = a.pop();
            for(int i = 0;i < n - 1;i ++) a.add(b.pop());
            return t;
        }

        /** Get the front element. */
        public int peek() {
            int n = a.size();
            for(int i = 0;i < n - 1;i ++) b.add(a.pop());
            int t = a.peek();
            for(int i = 0;i < n - 1;i ++) a.add(b.pop());
            return t;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return a.isEmpty();
        }
    }
}
