package com.gopher.leetcode;

import java.util.Random;

/**
 * @Title Code528
 * @Author fyw
 * @Date 2022/2/3 16:41
 * @Description:
 */
public class Code528 {
    private int[] preSum;
    private int sum;

    public Code528(int[] w) {
        preSum = new int[w.length+1];
        preSum[0] = 0;
        for (int i = 1; i <= preSum.length-1; i++) {
            preSum[i] = preSum[i - 1] + w[i-1];
        }
        sum = preSum[preSum.length-1];
    }

    public int pickIndex() {
        int target = new Random().nextInt(sum);
        return binSearchPreSumReturnWIndex(target);
    }

    private int binSearchPreSumReturnWIndex(int target) {
        int start = 0;
        int end = preSum.length - 1;
        int memo = 0;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (preSum[mid] == target) {
                return mid;
            }
            if (preSum[mid] < target) {
                memo = mid;     // 注意结束条件包括两个，一个是找到了正好等于目标值的索引，一个是找到小于目标值中最大值的索引
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return memo;
    }
}
