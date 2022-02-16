package com.gopher.leetcode.order.or200;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code290
 * @Author fyw
 * @Date 2022/2/9 14:47
 * @Description: 单词规律
 * 考察字符到字符串的双射
 */
public class Code290 {
    public boolean wordPattern(String pattern, String s) {
        String[] split= s.split(" ");
        if (pattern.length()!=split.length)
            return false;
        Map<Character,String> patternMap=new HashMap<>();
        Map<String,Character> sMap=new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (patternMap.containsKey(pattern.charAt(i))){
                if (!patternMap.get(pattern.charAt(i)).equals(split[i])){
                    return false;
                }
            }else{
                patternMap.put(pattern.charAt(i),split[i]);
            }
            if (sMap.containsKey(split[i])){
                if (sMap.get(split[i])!=pattern.charAt(i)){
                    return false;
                }
            }else{
                sMap.put(split[i],pattern.charAt(i));
            }
        }
        return true;
    }
}
