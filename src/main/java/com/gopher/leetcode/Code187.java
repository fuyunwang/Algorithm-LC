package com.gopher.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title Code187
 * @Author fyw
 * @Date 2022/2/1 21:02
 * @Description: 重复的DNA序列，类似Code884,Code49
 */
public class Code187 {
    public List<String> findRepeatedDnaSequences(String s) {
        // 核心在于枚举长度为10的子字符串并计数
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i+10 <= s.length(); i++) {
            String temp=s.substring(i,i+10);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        List<String> res=new ArrayList<>();
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if (entry.getValue()>1){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
