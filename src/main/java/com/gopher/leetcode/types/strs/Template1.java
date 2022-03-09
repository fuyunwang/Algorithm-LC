package com.gopher.leetcode.types.strs;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-03 19:34
 * @Description
 */
public class Template1 {
    static class Code49{
        // 方式1 排序
        public List<List<String>> groupAnagrams1(String[] strs) {
            List<List<String>> res=new ArrayList<>();
            HashMap<String,List<String>> map=new HashMap<>();
            for (String str:strs){
                char[] strArr=str.toCharArray();
                Arrays.sort(strArr);
                String cur=String.valueOf(strArr);
                if (map.containsKey(cur)){
                    map.get(cur).add(str);
                }else{
                    List<String> list=new ArrayList<>();
                    list.add(str);
                    map.put(cur,list);
                }
            }
            for (List<String> l:map.values()){
                res.add(l);
            }
            return res;
        }

        // 方式2 字符串哈希, p=131或者13331 Q=2^64
    }
    static class Code187{
        // 计算重复的长度为10的字符串
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res=new ArrayList<>();
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i+10 <= s.length(); i++) {
                String cur=s.substring(i,i+10);
                map.put(cur,map.getOrDefault(cur,0)+1);
            }
            for (Map.Entry<String,Integer> entry:map.entrySet()){
                int val=entry.getValue();
                if (val>1){
                    res.add(entry.getKey());
                }
            }
            return res;
        }

        static class Code187_1{
            int N = (int)1e5, P = 131313;
            int[] h = new int[N+10], p = new int[N+10];
            public List<String> findRepeatedDnaSequences(String s) {
                int n=s.length();
                p[0] = 1;
                for (int i = 1; i <= n; i++) {
                    h[i] = h[i - 1] * P + s.charAt(i - 1);
                    p[i] = p[i - 1] * P;
                }
                List<String> res=new ArrayList<>();
                Map<Integer,Integer> map=new HashMap<>();
                // 枚举长度为10的串
                for (int i = 1; i + 10 - 1<= s.length(); i++) {
                    // 计算长度为10的串的哈希值
                    int j=i+10-1;
                    int hash=h[j]-h[i-1]*p[j-i+1];

                    int count=map.getOrDefault(hash,0);
                    if (count==1) {
                        res.add(s.substring(i - 1, i + 10 - 1));
                    }
                    map.put(hash,count+1);

                }
                return res;
            }
        }
    }
    static class Code1044{
        long[] h, p;
        public String longestDupSubstring(String s) {
            int P = 1313131, n = s.length();
            h = new long[n + 10];
            p = new long[n + 10];
            p[0] = 1;
            for (int i = 1; i <= n; i++) {
                h[i] = h[i-1] * P + s.charAt(i-1);
                p[i] = p[i-1] * P;
            }
            String ans = "";
            // 二分枚举，此题的二段性在于最大长度实在左边还是在右边
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                String t = check(s, mid);
                if (t.length() != 0) l = mid;
                else r = mid - 1;
                ans = t.length() > ans.length() ? t : ans;
            }
            return ans;
        }
        String check(String s, int len) {       // check函数使用字符串hash来判断给定长度下是否存在合法方案
            int n = s.length();
            Set<Long> set = new HashSet<>();
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                long cur = h[j] - h[i - 1] * p[j - i + 1];
                if (set.contains(cur)) return s.substring(i - 1, j);
                set.add(cur);
            }
            return "";
        }

    }
    static class Code1002{
        // 查找共用字符。类似最长公共前缀
        public List<String> commonChars(String[] A) {
            List<String> list = new ArrayList<>();
            int[] res = new int[26];
            for (char c : A[0].toCharArray()) {
                res[c - 'a']++;
            }
            for (int i = 1; i < A.length; i++) {
                int[] temp = new int[26];
                for (char c : A[i].toCharArray()) {
                    temp[c - 'a']++;
                }
                for (int j = 0; j < 26; j++) {
                    res[j] = Math.min(res[j], temp[j]);
                }
            }
            for (int i = 0; i < res.length; i++) {
                if (res[i] > 0) {
                    for (int j = 0; j < res[i]; j++) {
                        list.add(((char) ('a' + i) + ""));
                    }
                }
            }
            return list;
        }
    }
    static class Code1816{
//        public String truncateSentence(String s, int k) {
//
//        }
    }
    static class Code2000{
        public String reversePrefix(String word, char ch) {
            int index=word.indexOf(ch);
            if (index<=0)
                return word;
            StringBuilder sb=new StringBuilder();
            sb.append(word.substring(0,index +1)).reverse();
            sb.append(word.substring(index+1));
            return sb.toString();
        }
    }
}
