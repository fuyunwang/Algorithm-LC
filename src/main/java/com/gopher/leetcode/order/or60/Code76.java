package com.gopher.leetcode.order.or60;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code76
 * @Author fyw
 * @Date 2022/2/9 12:35
 * @Description: 最小覆盖子串
 * 经典滑动窗口
 */
public class Code76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> window=new HashMap<>();
        Map<Character,Integer> need=new HashMap<>(); // 计算字符出现的次数来作为完成匹配的条件
        int left=0, right=0;
        int valid=0;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int start=0, len=Integer.MAX_VALUE;
        for (;right<s.length();){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // 临界条件
            for (;valid==need.size();){
                // 更新结果
                if (right-left<len){
                    start=left;
                    len=right-left;
                }

                char cc = s.charAt(left);
                left++;
                if (need.containsKey(cc)){
                    if (window.get(cc).equals(need.get(cc))){
                        valid--;
                    }
                    window.put(cc,window.getOrDefault(cc,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start + len);
    }
}
