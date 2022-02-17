package com.gopher.leetcode.order.or500;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Title Code503
 * @Author fyw
 * @Date 2022/2/9 14:10
 * @Description: 下一个更大元素
 * 循环查找下一个更大元素，从二倍的最后一个元素开始并取模
 */
public class Code503 {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[nums.length];
        Stack<Integer> stack=new Stack<>();
        for (int i=2*nums.length-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peek()<=nums[i%n]){
                stack.pop();
            }
            result[i%n]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return result;
    }
}
