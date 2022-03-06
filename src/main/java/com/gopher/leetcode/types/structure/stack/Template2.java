package com.gopher.leetcode.types.structure.stack;

import java.util.Stack;

/**
 * @Title Template2
 * @Author fyw
 * @Date 2022-03-06 20:45
 * @Description
 */
public class Template2 {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()||stack.peek()!=chars[i]){
                stack.push(chars[i]);
            }else{
                stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
