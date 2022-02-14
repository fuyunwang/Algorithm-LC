package com.gopher.leetcode.order.or1100;

import java.util.Stack;

/**
 * @Title Code1614
 * @Author fyw
 * @Date 2022/2/8 21:06
 * @Description:
 */
public class Code1614 {
    public int maxDepth(String s) {
        Stack<Character> stack=new Stack<>();
        int res=0;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                stack.push('(');
                count++;
            }else if (s.charAt(i)==')'){
                res=Math.max(res,count);
                count--;
                stack.pop();
            }
        }
        return res;
    }
}
