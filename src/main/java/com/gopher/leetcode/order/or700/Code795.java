package com.gopher.leetcode.order.or700;

/**
 * @Title Code795
 * @Author fyw
 * @Date 2022/2/8 21:05
 * @Description:
 */
public class Code795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j = -1, temp = 0, ans = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > R)
                j = i;
            if(A[i] >= L)
                temp = i - j;
            ans += temp;
        }
        return ans;
    }
}
