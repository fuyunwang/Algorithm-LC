package com.gopher.leetcode.swordoffer;

import java.util.Stack;

/**
 * @Title Code1
 * @Author fyw
 * @Date 2022-03-01 20:00
 * @Description 两个栈模拟队列
 */
public class Code1 {
    class CQueue {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        public CQueue() {
            stack1.clear();
            stack2.clear();
        }
        // 在队列尾部插入整数
        public void appendTail(int value) {
            stack1.push(value);
        }
        // 在队头删除整数
        public int deleteHead() {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty()?-1:stack2.pop();
        }
    }
}
