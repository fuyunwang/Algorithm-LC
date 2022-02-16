package com.gopher.leetcode.order.or200;

import java.util.HashMap;

/**
 * @Title Code205
 * @Author fyw
 * @Date 2022/2/9 14:11
 * @Description: 同构字符串
 * 双射
 */
public class Code205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> sMap=new HashMap<>();
        HashMap<Character,Character> tMap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))){
                if (sMap.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }else{
                sMap.put(s.charAt(i),t.charAt(i));
            }
            if (tMap.containsKey(t.charAt(i))){
                if (tMap.get(t.charAt(i))!=s.charAt(i))
                    return false;
            }else{
                tMap.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}
