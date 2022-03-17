package com.gopher.prac.leetcodeothers;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title Code720
 * @Author fyw
 * @Date 2022-03-17 10:58
 * @Description
 */
public class Code720 {
    public String longestWord(String[] words) {
        Set<String> set=new HashSet<>();
        for (String word:words){
            set.add(word);
        }
        String ans="";
        for (String cur:words){
            if (cur.length()<ans.length()){
                continue;
            }
            if (cur.length()==ans.length()&&cur.compareTo(ans)>0){// 判断字典序
                continue;
            }
            //题目表示是逐渐添加一个字母得到的，枚举每一种可能的情况
            boolean flag=false;
            for (int i = 1; i <= cur.length(); i++) {
                String sub=cur.substring(0,i);
                if (!set.contains(sub)){
                    flag=true;
                    break;
                }
            }
            if (!flag){
                // 说明是合理的答案
                ans=cur;
            }
        }
        return ans;
    }
}
