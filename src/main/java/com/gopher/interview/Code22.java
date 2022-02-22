package com.gopher.interview;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Title Code22
 * @Author fyw
 * @Date 2022-02-22 10:53
 * @Description 序列
 * m*n的矩阵，每行出一个数字求和，输出前k个最小的和
 * 多路归并
 */
public class Code22 {
    static int n, m, T;
    static int[] a;
    static int[] b;

    static void merge()
    {
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i ++ ) {
            heap.offer(new int[]{a[0] + b[i], 0});
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i ++ ) {
            int[] t = heap.poll();
            c[i] = t[0];
            if (t[1] + 1 < n)
                heap.offer(new int[]{t[0] - a[t[1]] + a[t[1] + 1], t[1] + 1});
        }
        System.arraycopy(c, 0, a, 0, n);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T -- > 0) {
            m = sc.nextInt();
            n = sc.nextInt();
            a = new int[n];
            b = new int[n];
            for (int i = 0; i < n; i ++ ) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            for (int i = 0; i < m - 1; i ++ ) {
                for (int j = 0; j < n; j ++ ) {
                    b[j] = sc.nextInt();
                }
                merge();
            }
            for (int i = 0; i < n; i ++ ) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}