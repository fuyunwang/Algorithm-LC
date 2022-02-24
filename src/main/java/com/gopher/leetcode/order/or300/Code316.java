package com.gopher.leetcode.order.or300;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title Code316
 * @Author fyw
 * @Date 2022/2/8 22:08
 * @Description: 去除重复字母
 * 贪心 单调栈
 */
public class Code316 {
    public String removeDuplicateLetters(String s) {
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
