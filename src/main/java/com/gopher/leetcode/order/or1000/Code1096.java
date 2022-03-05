package com.gopher.leetcode.order.or1000;

import java.util.List;
import java.util.Stack;

/**
 * @Title Code1096
 * @Author fyw
 * @Date 2022-03-05 19:29
 * @Description 花括号展开II
 */
public class Code1096 {
    int ptr = 0;
//    public List<String> braceExpansionII(String expression) {
//
//    }
    public int calculate(String s) {
//                s=s.replaceAll(" ","");
        Stack<Integer> nums = new Stack<>();
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
