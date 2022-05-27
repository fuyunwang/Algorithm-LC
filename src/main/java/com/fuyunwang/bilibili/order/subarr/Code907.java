package com.fuyunwang.bilibili.order.subarr;

import java.util.Stack;

/**
 * @Title Code907
 * @Author fyw
 * @Date 2022-05-25 9:08
 * @Description 子数组的最小值之和
 */
public class Code907 {
    /**
     * 单调栈
     * 类似于最大矩形、接雨水
     * 思想类似891
     */
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        int[] l=new int[n];
        int[] r=new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&&arr[i]<arr[stack.peek()])
                stack.pop();
            if (stack.isEmpty()){
                l[i]=-1;
            }else{
                l[i]=stack.peek();
            }
            stack.push(i);
        }
        stack=new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&arr[i]<=arr[stack.peek()])
                stack.pop();
            if (stack.isEmpty()){
                r[i]=n;
            }else{
                r[i]=stack.peek();
            }
            stack.push(i);
        }
        long res=0;
        long MOD= (long) (1e9+7);
        for (int i = 0; i < n; i++) {
            res+=(arr[i]*(long)(i-l[i])*(r[i]-i))%MOD;
        }
        return (int) (res%MOD);
    }
}
