package com.gopher.leetcode.order.or200;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title Code204
 * @Author fyw
 * @Date 2022/2/9 13:58
 * @Description: 计数质数
 * 求小于n的质数的个数
 * 用线性筛法把[0, n)的质数全部筛出来即可
 */
public class Code204 {
    public int countPrimes(int n) {
        boolean[] st = new boolean[n];  // 标记当前数是否被筛过，false表示没有被筛过
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (!st[i]) primes.add(i);
            for (int j = 0; i * primes.get(j) < n; j++) {
                st[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) break;
            }
        }
        return primes.size();
    }

}
