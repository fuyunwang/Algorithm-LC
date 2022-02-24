package com.gopher.leetcode.order.or300;

/**
 * @Title Code394
 * @Author fyw
 * @Date 2022/2/8 21:20
 * @Description: 字符串解码
 */
public class Code394 {
    int u;
    String s;

    public String decodeString(String _s) {
        u = 0;
        s = _s;
        return dfs();
    }

    public String dfs() {
        String res = "";
        while (u < s.length() && s.charAt(u) != ']') {
            if (Character.isLetter(s.charAt(u))) {
                res += s.charAt(u++);
            } else if (Character.isDigit(s.charAt(u))) {
                int j = u;
                while (j + 1 < s.length() && Character.isDigit(s.charAt(j + 1))) {
                    j++;
                }
                int times = Integer.parseInt(s.substring(u, j + 1));
                u = j + 2;
                String ne = dfs();
                u++;
                while (times > 0) {
                    res += ne;
                    times--;
                }
            }
        }
        return res;
    }

}
