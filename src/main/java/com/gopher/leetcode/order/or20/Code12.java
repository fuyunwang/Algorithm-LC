package com.gopher.leetcode.order.or20;

/**
 * @Title Code12
 * @Author fyw
 * @Date 2022/1/22 11:51
 * @Description: 整数转罗马数字
 */
public class Code12 {
    public String intToRoman(int num) {
        int[] values = new int[]{
                1000,
                900, 500, 400, 100,
                90, 50, 40, 10,
                9, 5, 4, 1
        };
        String[] sig = new String[]{
                "M",
                "CM", "D", "CD", "C",
                "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(sig[i]);
            }
        }
        return sb.toString();
    }
}
