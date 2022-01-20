package com.gopher.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code3
 * @Author fyw
 * @Date 2022/1/20 20:03
 * @Description:
 */
public class Code3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window=new HashMap<>();
        int left=0,right=0;
        int result=0;
        while (right<s.length()){
            char rc=s.charAt(right++);
            window.put(rc,window.getOrDefault(rc,0)+1);
            while (window.get(rc)>1){
                char lc=s.charAt(left++);
                window.put(lc,window.getOrDefault(lc,0)-1);
            }
            result = Math.max(result,right-left);
        }
        return result;
    }
}
