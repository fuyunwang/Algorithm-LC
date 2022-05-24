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
        Stack<Integer> minStack;
        Stack<Integer> oriStack;
        public MinStack() {
            minStack=new Stack<>();
            oriStack=new Stack<>();
        }

        public void push(int val) {
            oriStack.push(val);
            if (minStack.isEmpty()||minStack.peek()>=val){
                minStack.push(val);
            }else{
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            if (!oriStack.isEmpty()){
                oriStack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return oriStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
