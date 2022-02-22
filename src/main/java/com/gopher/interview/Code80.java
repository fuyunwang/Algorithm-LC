package com.gopher.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Title Code80
 * @Author fyw
 * @Date 2022-02-22 11:17
 * @Description 懒惰拼字赛
 * 乘法原理
 */
public class Code80 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int MOD = (int)1e9 + 7;
        int t = s.nextInt();
        for(int C = 1; C <= t; ++ C){
            String str= s.next();
            long res = 1;
            for(int i = 0; i < str.length(); ++ i){
                Set<Character> set = new HashSet<>();
                for(int j = Math.max(0, i - 1); j <= Math.min(str.length() - 1, i + 1); ++ j){
                    set.add(str.charAt(j));
                }
                //System.out.println(set.size());
                res = res * set.size() % MOD;
            }
            System.out.printf("Case #%d: %d\n", C, res);
        }
    }
}
