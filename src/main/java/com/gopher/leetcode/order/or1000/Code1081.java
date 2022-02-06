package com.gopher.leetcode.order.or1000;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code1081
 * @Author fyw
 * @Date 2022/2/6 13:23
 * @Description: 不同字符的最小子序列
 * 与316同一道题目
 */
public class Code1081 {
    public String smallestSubsequence(String s) {
        // 记录当前字符是否在结果字符串中出现过
        Map<Character,Boolean> inRes=new HashMap<>();
        // 记录当前字符在源字符串中的位置
        Map<Character,Integer> last=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i),i);
        }
        String res="";
        for (int i = 0; i < s.length(); i++) {
            if (inRes.containsKey(s.charAt(i))&&inRes.get(s.charAt(i)))
                continue;
            while (res.length()>0&&res.charAt(res.length()-1)>s.charAt(i)&&last.get(res.charAt(res.length()-1))>i){
                inRes.put(res.charAt(res.length()-1),false);
                res=res.substring(0,res.length()-1);
            }
            inRes.put(s.charAt(i),true);
            res=res+s.charAt(i);
        }

        return res;
    }
}
