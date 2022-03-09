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

    static class Code1003{
        public boolean isValid(String s) {
            /**
             如果是添加两个字符, 就相当于添加(),判断是否是有效的字符串 -> 栈
             对于三个字符abc, 遇到abc就删掉, 这样不会出现栈中交叉的情况
             如果合法, 栈一定为空
             */
            int n = s.length();
            char[] stk = new char[n]; int idx = -1;
            for (int i = 0; i < n; i ++){
                stk[++idx] = s.charAt(i);
                if (idx >= 2 && stk[idx] == 'c' && stk[idx-1] == 'b' && stk[idx-2] == 'a'){
                    idx -= 3;
                }
            }
            return idx == -1;
        }
    }
}
