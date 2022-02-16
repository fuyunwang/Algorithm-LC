package com.gopher.leetcode.order.or300;

/**
 * @Title Code306
 * @Author fyw
 * @Date 2022/2/9 13:38
 * @Description: 累加数
 * 判断给定的字符串是不是由斐波那契数组成的
 * 高精度加法
 */
public class Code306 {
    public String add(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        String C = "";
        for (int i = 0, c = 0; i < a.length() || i < b.length() || c > 0; i++) {
            if (i < a.length()) {
                c += a.charAt(i) - '0';
            }
            if (i < b.length()) {
                c += b.charAt(i) - '0';
            }
            C += c % 10;
            c /= 10;
        }
        return new StringBuilder(C).reverse().toString();
    }

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = -1;
                int b = i;
                int c = j;
                while (true) {
                    String s1 = num.substring(a + 1, b + 1);
                    String s2 = num.substring(b + 1, c + 1);
                    if (s1.length() > 1 && s1.charAt(0) == '0') {
                        break;
                    }
                    if (s2.length() > 1 && s2.charAt(0) == '0') {
                        break;
                    }
                    String s3 = add(s1, s2);
                    if (c + s3.length() + 1 <= n && num.substring(c + 1, s3.length() + c + 1).equals(s3)) {
                        a = b;
                        b = c;
                        c = c + s3.length();
                        if (c + 1 == num.length()) {
                            return true;
                        }
                    } else {
                        break;
                    }

                }
            }
        }
        return false;
    }
}
