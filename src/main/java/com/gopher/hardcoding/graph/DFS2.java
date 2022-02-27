package com.gopher.hardcoding.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Title DFS2
 * @Author fyw
 * @Date 2022-02-27 21:51
 * @Description 剪枝
 * 手段:
 * 1. 顺序，优先选择决策少的
 * 2. 排除冗余信息，如果一个分支与另一个分支接下来的搜索是等价，那么可以不必搜索
 * 3. 可行性剪枝
 * 4. 最优性剪枝
 *
 */
public class DFS2 {
    static class Code1{
        // 好题，小猫爬山
        private static int n, w;
        private static int N = 20;
        private static int[] nums = new int[N];
        private static int ans = N;
        private static int[] car = new int[N];
        private static int[] clone = new int[N];


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            w = Integer.parseInt(s[1]);
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(nums, 0, n);
            clone = nums.clone();
            for (int i = 0; i < n; i++) {
                nums[i] = clone[n - 1 - i];
            }
            dfs(0, 0);
            System.out.print(ans);
        }

        private static void dfs(int u, int k) {     // u表示当前要考虑第u只猫，k表示当前需要车的数量
            if (k >= ans)                           // ans表示当前已有方案中的最大值
                return;
            if (u == n) {
                ans = k;
                return;
            }
            for (int i = 0; i < k; i++) {           // 看当前猫能放到哪个车里面去
                if (car[i] + nums[u] <= w) {
                    car[i] += nums[u];
                    dfs(u + 1, k);
                    car[i] -= nums[u];
                }
            }
            car[k] = nums[u];                       // 已有车都放不下当前猫了，需要重新开一个新的方案
            dfs(u + 1, k + 1);
            car[k] = 0;
        }
    }

    static class Code2{
        // 数独

    }

    static class Code3{
         // 木棒
         // 剪枝：
            // 1. 木棒的长度必须能够整除木棍长度总和
            // 2. 优化搜索顺序，从大到小枚举
            // 3. 排除等效索引，采用组合数的方式来枚举，组合数的关键在于start参数
    }
}
