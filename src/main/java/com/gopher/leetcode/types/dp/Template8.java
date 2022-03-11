package com.gopher.leetcode.types.dp;

import java.util.*;

/**
 * @Title Template8
 * @Author fyw
 * @Date 2022/3/12 0:38
 * @Description: 记忆化搜索
 */
public class Template8 {
    static class Code135{
        // 类似基础课滑雪
        static int[] f;
        static int dfs(int x, int[] ratings)
        {
            if(f[x] != -1) return f[x];
            f[x] = 1;

            if(x - 1 >= 0 && ratings[x] > ratings[x - 1]) f[x] = Math.max(f[x], dfs(x - 1, ratings) + 1);
            if(x + 1 < ratings.length && ratings[x] > ratings[x + 1]) f[x] = Math.max(f[x], dfs(x + 1, ratings) + 1);

            return f[x];
        }
        public int candy(int[] ratings) {
            int n = ratings.length;
            f = new int[n + 10];
            Arrays.fill(f, -1);

            int res = 0;
            for(int i = 0;i < n;i ++) res += dfs(i, ratings);

            return res;
        }

    }
}
