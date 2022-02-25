package com.gopher.leetcode.order.or500;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Title Code519
 * @Author fyw
 * @Date 2022/2/9 14:01
 * @Description: 随机翻转矩阵
 * 类似堆
 */
public class Code519 {
    class Solution {
        int r, c, k;
        Map<Integer, Integer> hash;
        Random rand;

        public Solution(int n_rows, int n_cols) {
            r = n_rows;
            c = n_cols;
            k = r * c;
            rand = new Random();
            hash = new HashMap<>();
        }

        public int[] flip() {
            int x = rand.nextInt(k);
            int y = x;
            if (hash.containsKey(x)) {
                y = hash.get(x);
            }
            if (hash.containsKey(k - 1)) {
                hash.put(x, hash.get(k - 1));
                hash.remove(k - 1);
            } else {
                hash.put(x, k - 1);
            }
            k--;
            return new int[]{y / c, y % c}; // 一维数组索引到二维数组索引的映射
        }

        public void reset() {
            k = r * c;
            hash.clear();
        }
    }

}
