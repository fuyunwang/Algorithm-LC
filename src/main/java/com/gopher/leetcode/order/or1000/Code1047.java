package com.gopher.leetcode.order.or1000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Title Code1047
 * @Author fyw
 * @Date 2022/2/6 16:40
 * @Description:
 * 反复删除字符串中相邻字符，类似消消乐的过程
 */
public class Code1047 {
    public String removeDuplicates(String s) {
        LinkedList<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (stack.isEmpty())
                stack.addLast(c);
            else if (stack.peekLast()==c){
                stack.pollLast();
            }else{
                stack.addLast(c);
            }
        }
        if (stack.isEmpty())
            return "";
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
