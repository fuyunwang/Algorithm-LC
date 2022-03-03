package com.gopher.leetcode.types.strs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-03 19:34
 * @Description
 */
public class Template1 {
    static class Code49{
        // 方式1 排序
        public List<List<String>> groupAnagrams1(String[] strs) {
            List<List<String>> res=new ArrayList<>();
            HashMap<String,List<String>> map=new HashMap<>();
            for (String str:strs){
                char[] strArr=str.toCharArray();
                Arrays.sort(strArr);
                String cur=String.valueOf(strArr);
                if (map.containsKey(cur)){
                    map.get(cur).add(str);
                }else{
                    List<String> list=new ArrayList<>();
                    list.add(str);
                    map.put(cur,list);
                }
            }
            for (List<String> l:map.values()){
                res.add(l);
            }
            return res;
        }

        // 方式2 字符串哈希, p=131或者13331 Q=2^64

    }
}
