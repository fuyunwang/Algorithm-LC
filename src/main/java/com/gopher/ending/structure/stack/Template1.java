package com.gopher.ending.structure.stack;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-12 13:04
 * @Description
 */
public class Template1 {
    static class Code946{
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack=new Stack<>();
            int count=0;
            for (int i = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while(!stack.isEmpty()&&count<popped.length&&Objects.equals(stack.peek(),popped[count])){
                    stack.pop();
                    count++;
                }
            }
            return count==popped.length;
        }
    }
}
