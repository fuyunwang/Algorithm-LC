package com.gopher.leetcode.order.or500;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code500
 * @Author fyw
 * @Date 2022/2/9 14:35
 * @Description: 键盘行
 * 模拟
 */
public class Code500 {
    int[] c = new int[26];
    void init()
    {
        c['Q' - 'A'] = 1;
        c['W' - 'A'] = 1;
        c['E' - 'A'] = 1;
        c['R' - 'A'] = 1;
        c['T' - 'A'] = 1;
        c['Y' - 'A'] = 1;
        c['U' - 'A'] = 1;
        c['I' - 'A'] = 1;
        c['O' - 'A'] = 1;
        c['P' - 'A'] = 1;

        c['A' - 'A'] = 2;
        c['S' - 'A'] = 2;
        c['D' - 'A'] = 2;
        c['F' - 'A'] = 2;
        c['G' - 'A'] = 2;
        c['H' - 'A'] = 2;
        c['J' - 'A'] = 2;
        c['K' - 'A'] = 2;
        c['L' - 'A'] = 2;

        c['Z' - 'A'] = 3;
        c['X' - 'A'] = 3;
        c['C' - 'A'] = 3;
        c['V' - 'A'] = 3;
        c['B' - 'A'] = 3;
        c['N' - 'A'] = 3;
        c['M' - 'A'] = 3;
    }
    public String[] findWords(String[] words) {
        List<String> res=new ArrayList<>();
        init();
        for (int i = 0; i < words.length; i++) {
            String temp=words[i].toUpperCase();
            if (temp.length()==0)
                continue;
            int line=c[temp.charAt(0)-'A'];
            boolean flag=true; // 标识是否是同一行
            for (int j = 1; j < temp.length(); j++) {
                if (c[temp.charAt(j)-'A']!=line){
                    flag=false;
                    break;
                }
            }
            if (flag)
                res.add(words[i]);
        }
        return res.toArray(new String[0]);
    }
}
