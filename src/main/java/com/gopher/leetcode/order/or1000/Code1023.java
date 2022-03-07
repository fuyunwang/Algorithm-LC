package com.gopher.leetcode.order.or1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code1023
 * @Author fyw
 * @Date 2022-03-07 11:05
 * @Description
 */
public class Code1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res=new ArrayList<>();
        for(String q:queries){
            boolean check = check(pattern, q);
            res.add(check);
        }
        return res;
    }
    public boolean check(String a,String b){
        int i=0;
        int a_cnt=0;
        int b_cnt=0;
        for (int j = 0; j < b.length(); j++) {
            if (i<a.length()&&a.charAt(i)==b.charAt(j)){
                if(a.charAt(i)>='A'&&a.charAt(i)<='Z') {
                    a_cnt++;
                }
                i++;
            }
            if (b.charAt(j)>='A'&&b.charAt(j)<='Z'){
                b_cnt++;
            }
        }
        return i==a.length()&&a_cnt==b_cnt;
    }
}
