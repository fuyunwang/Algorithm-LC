package com.fuyunwang.bilibili.order.hot100;

/**
 * @Title Code5_647
 * @Author fyw
 * @Date 2022/5/24 22:08
 * @Description:
 */
public class Code5_647 {
    static class Code647{
        public int countSubstrings(String s) {
            int res=0;
            for (int i = 0; i < s.length(); i++) {
                // 奇数情况
                for (int j = i,k=i; j >=0 &&k<s.length(); j--,k++) {
                    if (s.charAt(j)!=s.charAt(k))
                        break;
                    res++;
                }
                // 偶数情况
                for (int j = i,k=i+1; j >=0 &&k<s.length(); j--,k++) {
                    if (s.charAt(j)!=s.charAt(k))
                        break;
                    res++;
                }
            }
            return res;
        }
    }
}
