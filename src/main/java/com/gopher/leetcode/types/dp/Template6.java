package com.gopher.leetcode.types.dp;

import java.util.*;

/**
 * @Title Template6
 * @Author fyw
 * @Date 2022-03-09 19:22
 * @Description 数位DP
 */
public class Template6 {
    static class Code1012{
        int P(int a, int b) {
            int res = 1;
            for (int i = a, j = 0; j < b; i --, j ++ )
                res *= i;
            return res;
        }
        public int numDupDigitsAtMostN(int n) {
            //数位dp或数位统计（统计满足要求的数字有多少个）
            //补集思想：总数-不含重复数字的正整数个数
            //画一棵树
            //f(n) 1~n之间每一位都不重复的数字个数
            LinkedList<Integer> nums = new LinkedList();
            int res = n;
            while (n > 0) {
                nums.offerLast(n % 10);
                n /= 10;
            }
            boolean[] st = new boolean[10];
            for (int i = 1; i < nums.size(); i++)
                res -= 9 * P(9, i - 1);
            res -= (nums.peekLast() - 1) * P(9, nums.size() - 1);

            st[nums.peekLast()] = true;
            for (int i = nums.size() - 2; i >= 0; i--) {
                int x = nums.get(i);
                for (int j = 0; j < x; j++)
                    if (!st[j])
                        res -= P(10 - (nums.size() - i), i);

                if (st[x]) return res;
                st[x] = true;
            }

            return res - 1;
        }
    }
}
