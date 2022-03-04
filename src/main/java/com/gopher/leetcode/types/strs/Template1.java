package com.gopher.leetcode.types.strs;

import java.util.*;

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
    static class Code187{
        // 计算重复的长度为10的字符串
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res=new ArrayList<>();
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i+10 <= s.length(); i++) {
                String cur=s.substring(i,i+10);
                map.put(cur,map.getOrDefault(cur,0)+1);
            }
            for (Map.Entry<String,Integer> entry:map.entrySet()){
                int val=entry.getValue();
                if (val>1){
                    res.add(entry.getKey());
                }
            }
            return res;
        }
    }
    static class COde1816{
//        public String truncateSentence(String s, int k) {
//
//        }
    }
    static class Code2000{
        public String reversePrefix(String word, char ch) {
            int index=word.indexOf(ch);
            if (index<=0)
                return word;
            StringBuilder sb=new StringBuilder();
            sb.append(word.substring(0,index +1)).reverse();
            sb.append(word.substring(index+1));
            return sb.toString();
        }
    }
}
