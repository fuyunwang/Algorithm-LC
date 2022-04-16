package com.gopher.leetcode.order.or700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Code763
 * @Author fyw
 * @Date 2022/2/8 21:56
 * @Description: 划分字母区间
 */
public class Code763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }

        int p=0;
        while (p<s.length()){
            char c=s.charAt(p);
            int pIndex=map.get(c);
            for (int i = 0; i <= pIndex; i++) {
                char cur=s.charAt(i);
                pIndex=Math.max(pIndex,map.get(cur));
            }
            res.add(pIndex-p+1);
            p=pIndex+1;
        }

        return res;
    }
}
