package com.gopher.leetcode.swordoffer;

import java.util.LinkedList;

/**
 * @Title Code2
 * @Author fyw
 * @Date 2022-03-01 20:22
 * @Description 包含min函数的栈
 */
public class Code2 {
    class MinStack {
        LinkedList<Integer> stack1=new LinkedList<>();
        LinkedList<Integer> stack2=new LinkedList<>();
        /** initialize your data structure here. */
        public MinStack() {
            stack1.clear();
            stack2.clear();
        }

        public void push(int x) {
            if (stack2.isEmpty()){
                stack2.push(x);
            }else{
                if (stack2.peek()<x){
                    stack2.push(stack2.peek());
                }else{
                    stack2.push(x);
                }
            }
            stack1.push(x);
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
