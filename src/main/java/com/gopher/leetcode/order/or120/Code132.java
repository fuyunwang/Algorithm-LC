package com.gopher.leetcode.order.or120;

import java.util.Arrays;

/**
 * @Title Code132
 * @Author fyw
 * @Date 2022/2/9 14:47
 * @Description: 分割回文串II
 * 分割的最少次数
 */
public class Code132 {
    // f[i]表示s[1~i]所有分割方案，属性是最小值
    // 最后一段是k~i
    // 预处理判断是否是回文串
    public int minCut(String s) {
        int n = s.length();
        s = " " + s;
        boolean[][] g = new boolean[n + 1][n + 1];
        for(int i = 1;i <= n;i ++)
            for(int j = 1;j <= i;j ++)
            {
                if(i == j) g[j][i] = true;
                else if(s.charAt(i) == s.charAt(j) && (i - 1 < j + 1 || g[j + 1][i - 1]))
                    g[j][i] = true;
            }

        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for(int i = 1;i <= n;i ++)
            for(int j = 1;j <= i;j ++)
            {
                if(g[j][i]) f[i] = Math.min(f[i], f[j - 1] + 1);
            }

        return f[n] - 1;
    }
}
