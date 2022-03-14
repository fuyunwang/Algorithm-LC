package com.gopher.ending.division;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-14 15:01
 * @Description
 */
public class Template1 {
    static class Code395{
        //  至少有K个重复字符的最长子串
        public int longestSubstring(String s, int k) {
            int res=0;
            for (int i = 1; i <= 26; i++) {     // 枚举最终结果中出现字符类型数的可能性
                int[] arr=new int[26];
                int l=0,r=0,kinds=0,ansKinds=0;
                while (r<s.length()){
                    arr[s.charAt(r)-'a']++;
                    if (arr[s.charAt(r)-'a']==1) kinds++;
                    if (arr[s.charAt(r)-'a']==k) ansKinds++;
                    r++;
                    while (kinds>i){
                        if (arr[s.charAt(l)-'a']==1) kinds--;
                        if (arr[s.charAt(l)-'a']==k) ansKinds--;
                        arr[s.charAt(l)-'a']--;
                        l++;
                    }
                    if (ansKinds==i) res=Math.max(res,r-l);
                }
            }
            return res;
        }
    }
}
