package com.gopher.prac.leetcodeothers;

import java.util.HashSet;

/**
 * @Title Code763
 * @Author fyw
 * @Date 2022-03-03 19:00
 * @Description 二进制表示中质数个计算置位
 */
public class Code762 {
    public int countPrimeSetBits(int left, int right) {
        // 最大范围是2^19
        HashSet<Integer> primes=new HashSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        int res=0;
        while (left<=right){
            int cur=0;
            // 获得二进制表示中所有1的个数
            for (int i = left; i > 0; i>>=1) {
                cur+=(i&1);
            }
            if (primes.contains(cur)){
                res++;
            }
            left++;
        }
        return res;
    }
}
