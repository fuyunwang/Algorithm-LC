package com.gopher.leetcode;

import java.util.*;

/**
 * @Title Code49
 * @Author fyw
 * @Date 2022/1/31 23:01
 * @Description:
 */
public class Code49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            final char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        List<List<String>> res=new ArrayList<>();
        for (List<String> list:map.values()){
            res.add(list);
        }
        return res;
    }
}
