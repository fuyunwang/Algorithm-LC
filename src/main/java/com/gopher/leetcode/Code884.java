package com.gopher.leetcode;

import java.util.*;

/**
 * @Title Code884
 * @Author fyw
 * @Date 2022/1/30 13:21
 * @Description: 类似Code187
 */
public class Code884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        StringBuilder sb=new StringBuilder();
        final String[] s = sb.append(s1).append(" ").append(s2).toString().split("\\s+"); // 分割空格
        Map<String,Integer> counts=new HashMap<>();
        for (String ss:s) {
            counts.put(ss,counts.getOrDefault(ss,0)+1);
        }
        List<String> list=new ArrayList<>();
        final Set<Map.Entry<String, Integer>> entries = counts.entrySet();
        for (Map.Entry<String,Integer> entry:entries){
            if (entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
