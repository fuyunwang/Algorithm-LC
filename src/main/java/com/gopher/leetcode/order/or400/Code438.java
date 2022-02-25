package com.gopher.leetcode.order.or400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Title Code438
 * @Author fyw
 * @Date 2022/2/9 13:39
 * @Description: 找到字符串中所有字母异位词
 * 滑动窗口
 */
public class Code438 {
    HashMap<Character,Integer> need=new HashMap<>();
    HashMap<Character,Integer> window=new HashMap<>();
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int left=0,right=0;
        int valid=0;
        for (char i:p.toCharArray()){
            need.put(i,need.getOrDefault(i,0)+1);
        }
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (right-left>=p.length()){
                if (valid==need.size()) res.add(left);
                char d=s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        return res;
    }
}
