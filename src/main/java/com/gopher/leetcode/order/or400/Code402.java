package com.gopher.leetcode.order.or400;

import java.util.LinkedList;

/**
 * @Title Code402
 * @Author fyw
 * @Date 2022/2/9 12:26
 * @Description: 移掉K位数字
 * Code316
 */
public class Code402 {
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
