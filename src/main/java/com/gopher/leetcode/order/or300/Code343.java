package com.gopher.leetcode.order.or300;

/**
 * @Title Code343
 * @Author fyw
 * @Date 2022/2/9 12:29
 * @Description: 整数拆分
 * 结论：想让分割出的数乘积最大，优先拆成3，其次是2。分解出的数不包含1且不包含大于等于4的数
 */
public class Code343 {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int p = 1;
        while (n >= 5) {
            n -= 3;
            p *= 3;
        }
        return p * n;
    }
}
