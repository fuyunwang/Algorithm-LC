package com.gopher.leetcode;

import java.util.HashMap;

/**
 * @Title Code13
 * @Author fyw
 * @Date 2022/1/22 11:56
 * @Description: 罗马数字转整数
 */
public class Code13 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result=0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1&&map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                result-=map.get(s.charAt(i));
            }else{
                result+=map.get(s.charAt(i));
            }
        }
        return result;
    }
}
