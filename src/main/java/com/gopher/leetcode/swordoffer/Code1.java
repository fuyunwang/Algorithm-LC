package com.gopher.leetcode.swordoffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Title Code1
 * @Author fyw
 * @Date 2022-03-01 20:00
 * @Description 两个栈模拟队列
 */
public class Code1 {
    class CQueue {
        LinkedList<Integer> stack1=new LinkedList<>();
        LinkedList<Integer> stack2=new LinkedList<>();
        public CQueue() {
            stack1.clear();
            stack2.clear();
        }
        // 在队列尾部插入整数
        public void appendTail(int value) {
            stack1.push(value);
        }
        // 在队头删除整数，
        // 注意有个状态可能stack2中有元素stack1中也有元素，那么此时
            // stack2不为空，stack2第一个元素直接返回，这可能是多次调用，放心返回就可以。
            // stack2为空，stack2第一次初始化
        public int deleteHead() {
            if (stack2.isEmpty()){
                if(stack1.isEmpty())
                    return -1;
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
