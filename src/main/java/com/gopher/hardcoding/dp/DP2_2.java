package com.gopher.hardcoding.dp;

import java.util.Scanner;

/**
 * @Title DP2_2
 * @Author fyw
 * @Date 2022-02-26 14:40
 * @Description 最长上升子序列模型2
 */
public class DP2_2 {
    // 拦截导弹
    static class Code5{
        static Scanner in = new Scanner(System.in);
        static int N = 1010;
        static int h[] = new int[N], f[] = new int[N], g[] = new int[N];

        public static void main(String args[])
        {
            int n = 0, res = 0, cnt = 0;
            while (in.hasNext()) h[n++] = in.nextInt();
            for (int i = 0; i < n; i++)
            {
                f[i] = 1;
                for (int j = 0; j < i; j++)
                    if (h[j] >= h[i])
                        f[i] = Math.max(f[i], f[j] + 1);
                res = Math.max(res, f[i]);
                int k = 0;
                while (k < cnt && g[k] < h[i]) k++;
                if (k == cnt) g[cnt++] = h[i];
                else g[k] = h[i];
            }
            System.out.println(res + "\n" + cnt);
        }
    }
}
