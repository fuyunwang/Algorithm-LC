package com.gopher.leetcode.types.backtrack;

import java.util.*;

/**
 * @Title BacktrackTemplate2
 * @Author fyw
 * @Date 2022/1/29 20:09
 * @Description: 做选择生成结果
 */
public class BacktrackTemplate2 {
    static class Code17{
        // 全排列变形
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
            if(digits.length()==0){
                return Collections.emptyList();
            }
            backtrack(digits,0,new StringBuilder());
            return res;
        }
        void backtrack(String digits,int index,StringBuilder sb){
            if (index==digits.length()){
                res.add(new StringBuilder(sb).toString());
                return;
            }
            String substring = digits.substring(index, index + 1);
            for (int i = 0; i < map.get(substring).length(); i++) { // 对于当前字符可进行的选择进行遍历
                sb.append(map.get(substring).charAt(i));
                backtrack(digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
    static class Code22{
        List<String> res=new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            backtrack(n,0,0,new StringBuilder());
            return res;
        }
        void backtrack(int n,int l,int r,StringBuilder sb){
            if (l==n&&r==n){
                res.add(new StringBuilder(sb).toString());
                return;
            }
            if (l<n){
                backtrack(n,l+1,r,sb.append("("));
                sb.deleteCharAt(sb.length()-1);
            }
            if (r<n&&r<l){
                backtrack(n,l,r+1,sb.append(")"));
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
