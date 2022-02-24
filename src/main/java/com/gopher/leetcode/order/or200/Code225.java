package com.gopher.leetcode.order.or200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title Code225
 * @Author fyw
 * @Date 2022/2/9 14:39
 * @Description: 用队列实现栈
 */
public class Code225 {
    class MyStack {
        Queue<Integer> q = new LinkedList<Integer>();

        public MyStack() {
            q.clear();
        }

        public void push(int x) {
            q.add(x);
        }

        public int pop() {
            int n = q.size();
            for(int i = 0;i < n - 1;i ++) q.add(q.poll());
            return q.poll();
        }

        public int top() {
            int n = q.size();
            for(int i = 0;i < n - 1;i ++) q.add(q.poll());
            int x = q.poll();
            q.add(x);
            return x;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
