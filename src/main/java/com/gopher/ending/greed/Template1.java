package com.gopher.ending.greed;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-12 12:48
 * @Description
 */
public class Template1 {


    static class Code955{
        public int minDeletionSize(String[] strs) {
            int n = strs.length ;
            int m = strs[0].length() ;
            int ret = 0 ;
            boolean [] f = new boolean[n] ;
            for (int i = 0; i < m ; ++i) {
                boolean flag = true ;
                for (int j = 1; j < n ; ++j) {
                    if (!f[j] && strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                        flag = false;
                    }
                }
                if (!flag) {
                    ret++ ;
                } else {
                    for (int j = 1 ;j < n ; ++j) {
                        if (!f[j] && strs[j - 1].charAt(i) < strs[j].charAt(i)) {
                            f[j] = true ;
                        }
                    }
                }
            }
            return ret ;
        }
    }

    static class Code857{

    }
}