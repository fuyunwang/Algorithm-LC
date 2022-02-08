package com.gopher.interview;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Title Code6
 * @Author fyw
 * @Date 2022/2/8 17:56
 * @Description: 移掉K位数字,LeetCode402类似题目还有LeetCode1081 LeetCode321 LeetCode316
 * 贪心 单调栈
 */
public class Code6 {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack=new LinkedList<>();
        int n=num.length();
        char[] nums=num.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = nums[i];
            while (k>0&&!stack.isEmpty()&&stack.peekLast()>c){
                stack.pollLast();
                k--;
            }
            stack.addLast(c);
        }
        while (k>0&&!stack.isEmpty()){
            stack.pollLast();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        String res=sb.reverse().toString();
        int index=0;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i)=='0'){
                index++;
            }else if (res.charAt(i)!='0'){
                break;
            }
        }
        return index==res.length()?"0":res.substring(index);
    }
}
