package com.gopher.leetcode.order.or120;

import java.util.Stack;

/**
 * @Title Code150
 * @Author fyw
 * @Date 2022/2/9 14:06
 * @Description: 逆波兰表达式求值
 * 后缀表达式求值，即根据表达式树的后序遍历求值，其中表达式树叶子节点为数字，非叶子节点为运算符
 */
public class Code150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0;i < tokens.length;i ++)
        {
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            {
                int b = stk.pop();
                int a = stk.pop();
                if(s.equals("+")) a += b;
                else if(s.equals("-")) a -= b;
                else if(s.equals("*")) a *= b;
                else a /= b;

                stk.add(a);
            }
            else stk.add(Integer.parseInt(s));
        }
        return stk.pop();
    }
}
