package com.gopher.leetcode;

import java.util.Map;
import java.util.Stack;

/**
 * @Title COde1124
 * @Author fyw
 * @Date 2022/2/4 13:53
 * @Description: 表现良好的最长时间段，类似Code560
 * 给定一个数组和一个标准值，求数组中的一个连续子区间满足大于标准值的个数大于小于标准值的个数
 *
 * 大于标准值的数统一成 1，小于标准值的数统一成 -1，目的求子区间中和大于0的最长类，前缀和数组
 *
 * 找到一个(i,j)使得prefixSum[j] - prefixSum[i] > 0
 *
 * 尽可能使得prefixSum[i]更小这样才可能大于0，单调递减栈开始存放元素
 *
 * 不断更新结果使得j-i最大
 *
 */
public class Code1124 {
    // 求 presum 数组中的一个最长的上坡，可以用单调栈实现,presum = [0, 1, 2, 1, 0, -1, -2, -1]
    public int longestWPI(int[] hours) {
        int[] sum=new int[hours.length+1];
        sum[0]=0;
        for (int i = 1; i <= hours.length; i++) {
            sum[i]=(hours[i-1]>8?1:-1) + sum[i-1];
        }
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < sum.length; i++) {
            while (stack.isEmpty()||sum[stack.peek()]>sum[i]){
                stack.push(i);
            }
        }

        int res=0;
        for (int i = sum.length-1; i >= 0; i--) {
           while (!stack.isEmpty()&&sum[stack.peek()]<sum[i])
               res= Math.max(res,i-stack.pop());
        }
        return res;
    }
}
