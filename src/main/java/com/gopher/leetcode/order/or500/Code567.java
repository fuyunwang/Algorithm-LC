package com.gopher.leetcode.order.or500;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code567
 * @Author fyw
 * @Date 2022/2/8 22:06
 * @Description: 字符串的排列
 */
public class Code567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> window=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>();
        int left=0,right=0;
        int valid=0;
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);
        }
        for (;right<s2.length();){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (right-left>=s1.length()){
                if (valid==need.size())
                    return true;
                char cc = s2.charAt(left);
                left++;
                if (need.containsKey(cc)){
                    if (window.get(cc).equals(need.get(cc))){
                        valid--;
                    }
                    window.put(cc,window.getOrDefault(cc,0)-1);
                }
            }
        }
        return false;
    }
}
