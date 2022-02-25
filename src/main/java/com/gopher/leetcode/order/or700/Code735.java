package com.gopher.leetcode.order.or700;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Title Code735
 * @Author fyw
 * @Date 2022/2/9 13:52
 * @Description: 行星碰撞
 */
public class Code735 {
    public int[] asteroidCollision(int[] as) {
        Deque<Integer> stk = new ArrayDeque<>();
        for(int x: as){
            if(x > 0){
                stk.push(x);                                                                // 全为正向
            }else{
                while(stk.size() > 0 && stk.peek() > 0 && stk.peek() < -x) stk.pop();       // 一个正向一个逆向
                if(stk.size() == 0 || stk.size() > 0 && stk.peek() < 0) stk.push(x);        // 全为逆向
                else if(stk.size() > 0 && stk.peek() == -x) stk.pop();
            }
        }
        int[] res = new int[stk.size()];
        int k = stk.size() - 1;
        while(stk.size() > 0){
            res[k--] = stk.pop();
        }
        return res;
    }
}
