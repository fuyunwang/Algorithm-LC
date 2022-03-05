package com.gopher.leetcode.types.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title BitCalculate
 * @Author fyw
 * @Date 2022-03-05 19:56
 * @Description 位运算
 */
public class BitCalculate {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res=new ArrayList<>();
        while (label>0){
            res.add(label);
            label>>=1;
        }
        Collections.reverse(res);
        // 对于指定位置异或全1，即2^i-1
        for (int i=res.size()&1;i<res.size();i+=2){
            res.set(i,res.get(i)^((1<<i)-1));
        }
        return res;
    }
}
