package com.gopher.leetcode.types.window;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-01 21:28
 * @Description
 */
public class Template1 {
    static class Code3{
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> window=new HashMap<>();
            int left=0,right=0;
            int res=0;
            while (right<s.length()){
                char rc=s.charAt(right++);
                window.put(rc,window.getOrDefault(rc,0)+1);
                while (window.get(rc)>1){
                    char lc=s.charAt(left++);
                    window.put(lc,window.getOrDefault(lc,0)-1);
                }
                res=Math.max(res,right-left);
            }
            return res;
        }
    }
    static class Code30{
        public List<Integer> findSubstring(String s, String[] words) {
            if (words==null||words.length==0)
                return Collections.emptyList();
            // 注意这里是不需要顺序的，所以统计词频
            Map<String,Integer> freq=new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                freq.put(words[i],freq.getOrDefault(words[i],0)+1);
            }
            // 声明结果数组
            List<Integer> res=new ArrayList<>();
            // 开始枚举，注意n个相同长度的字符串的枚举范围
            int n=words.length;
            int len=words[0].length();
            Map<String,Integer> map=new HashMap<>();// 用于临时比较频次
            for (int i = 0; i <= s.length()-n*len; i++) {
                map.clear();
                int count=0;    // 计数，恰好由所有单词拼凑而成
                while (count<n){
                    String rString=s.substring(i+count*len,i+(count+1)*len);    // 枚举每个单词
                    if (freq.containsKey(rString)){
                        map.put(rString,map.getOrDefault(rString,0)+1);
                        if (map.get(rString)>freq.get(rString)){
                            // 说明原始频次不够用
                            break;
                        }
                    }else{
                        // 说明当前开始的索引拼不出，直接进入下一轮次
                        break;
                    }
                    count++;
                }
                if (count==n){
                    // 说明有结果
                    res.add(i); // 只记录起始索引
                }
            }
            return res;
        }
    }
    static class Code76{

    }
}
