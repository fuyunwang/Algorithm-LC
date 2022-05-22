package com.fuyunwang.bilibili.order.hot100;

import java.util.Stack;

/**
 * @Title Code155
 * @Author fyw
 * @Date 2022/5/22 20:15
 * @Description:
 */
public class Code155 {
    class MinStack {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        public MinStack() {
        }

        public void push(int val) {
            if (stack1.isEmpty()){
                stack1.push(val);
            }
            if (stack1.peek()<val){
                stack1.push(stack1.peek());
            }
            stack2.push(val);
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            stack1.pop();
            return stack2.pop();
        }

        public int getMin() {
            return stack1.peek();
        }
    }
}
