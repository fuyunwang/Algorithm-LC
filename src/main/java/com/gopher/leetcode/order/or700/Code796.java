package com.gopher.leetcode.order.or700;

/**
 * @Title Code796
 * @Author fyw
 * @Date 2022/2/9 14:46
 * @Description: 旋转字符串
 */
public class Code796 {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
