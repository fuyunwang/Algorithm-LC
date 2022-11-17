package com.gopher.leetcode.order.or400;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code409
 * @Author fyw
 * @Date 2022/2/9 14:04
 * @Description: 最长回文串
 */
public class Code409 {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res=0;
        int sum=0;
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            res+=entry.getValue()/2*2;
            sum+=entry.getValue();
        }
        return res<sum?res+1:res;
    }
}
