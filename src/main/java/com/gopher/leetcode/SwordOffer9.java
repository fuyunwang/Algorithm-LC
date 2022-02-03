package com.gopher.leetcode;

import java.util.Stack;

/**
 * @Title SwordOffer9
 * @Author fyw
 * @Date 2022/2/3 19:32
 * @Description:
 */
public class SwordOffer9 {
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()){
                if (stack1.isEmpty()) return -1;
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }else{
                return stack2.pop();
            }
        }
    }
}
