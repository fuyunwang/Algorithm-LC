package com.gopher.leetcode.types.structure.treearray;

import java.util.*;

/**
 * @Title Template1
 * @Author fyw
 * @Date 2022-03-11 9:37
 * @Description
 */
public class Template1 {
    static class Code315 {
        public List<Integer> countSmaller(int[] nums) {
            int[] a = nums.clone();
            Arrays.sort(a);

            int k = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                if (i == 0 || a[i] != a[i - 1]) {
                    map.put(a[i], k++);
                }
            }


            Ft f = new Ft(k);
            List<Integer> ans = new ArrayList<>();
            for (int i = n - 1; i >= 0; --i) {
                int p = map.get(nums[i]);
                int cnt = f.query(p - 1);
                ans.add(cnt);
                f.update(p, 1);
            }
            Collections.reverse(ans);
            return ans;
        }


        class Ft {
            int[] bits;

            Ft(int n) {
                bits = new int[n + 1];
            }

            private int lowbit(int x) {
                return x & (~x + 1);
            }

            int query(int i) {
                int sum = 0;
                for (int k = i + 1; k > 0; k -= lowbit(k)) {
                    sum += bits[k];
                }
                return sum;
            }

            void update(int i, int delta) {
                for (int k = i + 1; k < bits.length; k += lowbit(k)) {
                    bits[k] += delta;
                }
            }
        }
    }
}
