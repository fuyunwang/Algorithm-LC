package com.gopher.leetcode.types.structure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-04 20:41
 * @Description
 */
public class Template1 {
    static class Code150{
        // 逆波兰表达式求值，后缀表达式
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                String cur=tokens[i];
                if (cur.equals("+")||cur.equals("-")||cur.equals("*")||cur.equals("/")){
                    int b=stack.pop();
                    int a=stack.pop();
                    if (cur.equals("+")) a+=b;
                    else if (cur.equals("-")) a-=b;
                    else if (cur.equals("*")) a*=b;
                    else a/=b;
                    stack.push(a);
                }else{
                    stack.push(Integer.parseInt(cur));
                }
            }
            return stack.pop();
        }
    }
    static class Template{
        int ptr = 0;
        public int calculate(String s) {
            Stack<Integer> nums = new Stack<>();
            s=s.replaceAll(" ","");
            char sign = '+';
            int num = 0;
            while (ptr <= s.length()) {  // ptr == s.length() 意味着把剩余未放入栈的数字进行处理
                if (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
                    num = num*10 + s.charAt(ptr) - '0';
                    ptr++;
                } else if (ptr < s.length() && s.charAt(ptr) == '(') {
                    ptr++;
                    num = calculate(s);
                } else {
                    switch (sign) {
                        case '+':
                            nums.push(num);
                            break;
                        case '-':
                            nums.push(-num);
                            break;
                        case '*':
                            nums.push(nums.pop() * num);
                            break;
                        case '/':
                            nums.push(nums.pop() / num);
                            break;
                    }
                    num = 0;
                    if (ptr < s.length() && s.charAt(ptr) == ')') {
                        ptr++;
                        break;
                    }
                    if (ptr < s.length()) sign = s.charAt(ptr);
                    ptr++;
                }
            }
            
            int sum = 0;
            while (!nums.isEmpty()) sum += nums.pop();
            return sum;
        }
    }
}
