package com.gopher.leetcode.types.greed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code316
 * @Author fyw
 * @Date 2022/2/6 13:27
 * @Description:
 */
public class Code316 {
    // 贪心 核心思想：从前到后扫描每个字符，如果当前字符更小后面的字符删除，如果当前字符之前的字符更大并且在当前字符之后出现过则删除
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        Map<Character,Boolean> pre=new HashMap<>(); // 控制第一个条件满足
        Map<Character,Integer> post=new HashMap<>(); // 控制第二个条件满足

        for (int i = 0; i < s.length(); i++) {
            post.put(s.charAt(i),i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (pre.getOrDefault(s.charAt(i),false)){
                continue;
            }
            while (!stack.isEmpty()&&stack.peekLast()>s.charAt(i)&&post.get(stack.peekLast())>i){
                // 此时说明栈中最后一个字符更大且后面还有存在
                pre.put(stack.peekLast(),false);
                stack.pollLast();
            }
            stack.addLast(s.charAt(i));
            pre.put(s.charAt(i),true);
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
