package com.gopher.leetcode.order.or300;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Title Code350
 * @Author fyw
 * @Date 2022/2/9 12:43
 * @Description:
 */
public class Code350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int n : nums1) hs.put(n, hs.getOrDefault(n, 0) + 1);
        int[] res = new int[nums1.length];
        int idx = 0;
        for (int n : nums2) {
            if (hs.containsKey(n) && hs.get(n) > 0) {
                res[idx++] = n;
                hs.put(n, hs.get(n) - 1);
            }
        }
        return Arrays.copyOf(res, idx);
    }
}
