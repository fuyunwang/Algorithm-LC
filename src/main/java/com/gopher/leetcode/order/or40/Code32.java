package com.gopher.leetcode.order.or40;

import java.util.Stack;

/**
 * @Title Code32
 * @Author fyw
 * @Date 2022/1/24 13:15
 * @Description:
 */
public class Code32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int result=0;
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()||s.charAt(i)=='('){
                stack.push(i);
            }else{
                if (s.charAt(stack.peek())=='('){
                    final Integer pop = stack.pop();
                    if (stack.isEmpty()){
                        result=i+1;
                    }else{
                        result=Math.max(result,i-stack.peek());
                    }
                }else{
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
