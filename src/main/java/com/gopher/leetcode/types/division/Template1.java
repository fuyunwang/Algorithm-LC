package com.gopher.leetcode.types.division;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-08 20:28
 * @Description
 */
public class Template1 {
    static class Code761{
        public String makeLargestSpecial(String S) {
            if (S.length() <= 2) {
                return S;
            }
            List<String> list = new ArrayList<>();
            int cnt = 0;
            int t = 0;

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '1') {
                    cnt++;
                } else {
                    cnt--;
                }
                if (cnt == 0) {
                    list.add("1" + makeLargestSpecial(S.substring(t + 1, i)) + "0");
                    t = i + 1;
                }
            }
            Collections.sort(list, (a, b) -> {
                return (b + a).compareTo(a + b);
            });
            String res = "";
            for (String str : list) {
                res += str;
            }
            return res;
        }
    }
}
