package com.gopher.leetcode.order.or30;

import java.util.*;

/**
 * @Title Code30
 * @Author fyw
 * @Date 2022/2/9 13:31
 * @Description: 滑动窗口解决串联所有单词的子串
 */
public class Code30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words==null||words.length==0)
            return Collections.emptyList();
        List<Integer> res=new ArrayList<>();
        Map<String,Integer> freq=new HashMap<>();
        for (String word:words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        int n=words.length;
        int len=words[0].length();
        Map<String,Integer> map=new HashMap<>();    // map的作用是与freq进行对比
        for (int i = 0; i <=s.length()-n*len ; i++) {   // 进行substring
            map.clear();
            int j=0;
            while (j<n){
                String test=s.substring(i+j*len,i+j*len+len);// 每次取出len个长度检查
                if (freq.containsKey(test)){
                    map.put(test,map.getOrDefault(test,0)+1);
                    if (map.get(test)>freq.get(test))       // 说明此时从i位置开始是凑不出的
                        break;
                }else{
                    break; // 说明此时从i位置开始是凑不出的
                }
                j++;
            }
            if (j==n){
                // 说明此时配出了
                res.add(i);
            }
        }
        return res;
    }
}
