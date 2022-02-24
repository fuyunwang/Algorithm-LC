package com.gopher.leetcode.order.or300;

/**
 * @Title Code396
 * @Author fyw
 * @Date 2022/2/13 21:59
 * @Description: 旋转函数
 * 利用第一行的结果来计算后续行结果，找规律
 */
public class Code396 {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += i * A[i];
        }
        int res = cur;
        for (int i = n - 1; i >= 0; i--) {
            cur += sum - n * A[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}
