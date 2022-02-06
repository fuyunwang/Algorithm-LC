package com.gopher.leetcode.order.or20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Title Code17
 * @Author fyw
 * @Date 2022/1/22 20:17
 * @Description: 电话号码的字母组合
 */
public class Code17 {
    List<String> res=new LinkedList<>();
    HashMap<String,String> map = new HashMap<String,String>()
    {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()<1)
            return new ArrayList<>();
        backtrack(digits,"",0);
        return res;
    }

    public void backtrack(String digits,String state,int start){
        if (start==digits.length()){
            res.add(state);
            return;
        }
        String current=map.get(digits.substring(start,start+1));
        for (int i = 0; i < current.length(); i++) {
            backtrack(digits,state+current.charAt(i),start+1);
        }
    }

}
