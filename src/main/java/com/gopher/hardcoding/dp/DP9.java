package com.gopher.hardcoding.dp;

import java.io.*;
import java.util.*;

/**
 * @Title DP9
 * @Author fyw
 * @Date 2022-02-26 13:23
 * @Description 单调队列优化DP
 */
public class DP9 {
    static class Code1{
        // 输入一个长度为 n 的整数序列，从中找出一段长度不超过 m 的连续子序列，使得子序列中所有数的和最大。
        // 前缀和、单调递增队列
        // 对于每一个位置i，从前面m长的区间内找到一点j使得Sj最小，那么Si-Sj-1最大
        static int n;
        static int m;
        static int N = (int) (3e5 + 10);
        static int INF=0x3f3f3f3f;
        static long[] sum = new long[N];
        static LinkedList<Integer> queue = new LinkedList<Integer>();
        static long ans=-INF;
        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
            String[] str = reader.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            str = reader.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                sum[i] = Long.parseLong(str[i - 1]);
                sum[i] = sum[i - 1] + sum[i];
            }
            // 加0 方便计算S0
            queue.addLast(0);
            for (int i = 1; i <= n; i++) {
                while (!queue.isEmpty() && queue.peek() <= i - m-1)
                    queue.removeFirst();
                if (!queue.isEmpty())
                    ans = Math.max(ans, sum[i] - sum[queue.peek()]);
                while (!queue.isEmpty() && sum[queue.getLast()] >= sum[i])
                    queue.removeLast();
                queue.addLast(i);
            }
            System.out.println(ans);
        }

    }
}
