package com.gopher.hot100_300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Title Code739
 * @Author fyw
 * @Date 2022/4/23 10:53
 * @Description: 每日温度
 * 求数组中每个数右侧第一个比他大的数
 */
public class Code739 {
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for (int i = temperatures.length-1; i >= 0 ; i--) {
            while (!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()])
                stack.pop();
            if (!stack.isEmpty()){
                res.add(stack.peek()-i);
            }else{
                res.add(0);
            }
            stack.push(i);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
