package com.gopher.leetcode.order.or1100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title Code1104
 * @Author fyw
 * @Date 2022/2/4 21:16
 * @Description: 1<<i相当于 2的i次方
 */
public class Code1104 {
    public List<Integer> pathInZigZagTree(int label) {
        // 使用异或可以实现翻转
        List<Integer> res=new ArrayList<>();
        while (label>0){
            res.add(label);
            label>>=1;
        }
        Collections.reverse(res);
        for (int i=res.size()&1;i<res.size();i+=2){
            res.set(i,res.get(i)^((1<<i)-1));
        }

        return res;
    }
}
