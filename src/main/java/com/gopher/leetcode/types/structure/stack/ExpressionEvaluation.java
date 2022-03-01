package com.gopher.leetcode.types.structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Title ExpressionEvaluation
 * @Author fyw
 * @Date 2022/2/2 17:26
 * @Description: 中缀表达式求值
 */
public class ExpressionEvaluation {
    public static void main(String[] args) throws IOException {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('+',1);
        priorityMap.put('-',1);
        priorityMap.put('*',2);
        priorityMap.put('/',2);
        priorityMap.put('(',-1); //保证左括号后的第一个运算符能直接入栈
        char[] chs = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

    }
    void eval(Stack<Character> ops,Stack<Integer> nums){
        final Integer val1 = nums.pop();
        final Integer val2 = nums.pop();
        final Character op = ops.pop();
        if (op=='+'){
            nums.push(val2+val1);
        }else if (op=='-'){
            nums.push(val2-val1);
        }else if (op=='*'){
            nums.push(val2*val1);
        }else{
            nums.push(val2/val1);
        }
    }
}
