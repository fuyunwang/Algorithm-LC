package com.gopher.leetcode.order.or400;

/**
 * @Title Code481
 * @Author fyw
 * @Date 2022/2/13 19:03
 * @Description: 神奇字符串
 * 类似外观数列
 */
public class Code481 {
    public int magicalString(int n) {
        // 模拟前n位然后返回1的个数，每个字符描述了当前字符已经可能的后续字符
        StringBuilder sb=new StringBuilder("122");
        for (int i = 2, k=1; sb.length()<n; i++,k=3-k) {     // 添加的值是按照1、2交错来的，所以k=3-k
            for (int j = 0; j < sb.charAt(i)-'0'; j++) {    // j的作用是根据当前位置的数字来模拟位数
                sb.append(k);
            }
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            res+=sb.charAt(i)=='1'?1:0;
        }
        return res;
    }
}
