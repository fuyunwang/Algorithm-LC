package com.gopher.swordoffer;

import java.util.*;

/**
 * @Title SO0333
 * @Author fyw
 * @Date 2022-03-03 19:27
 * @Description 异位词
 */
public class SO033 {
    // 方式1 排序
    public List<List<String>> groupAnagrams(String[] strs) {
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

    // 方式2 字符串哈希


    static long [] hash ;
    static long [] p ;
    static int base = 131 ;
    static long mod = Long.MAX_VALUE;

    public static void h (String t){
        int n = t.length();
        hash = new long[n + 1];
        p = new long[n + 1] ;
        p[0] = 1;
        for (int i = 1; i <= n ; ++i) {
            hash[i] = (hash[i - 1] * base + (t.charAt(i - 1) - 'a' + 1)) % mod;
            p[i] = p[i - 1] * 131;
        }
    }

    public static long get(int l, int r){
        return hash[r] - hash[l - 1] * p[r - l + 1];
    }

}
